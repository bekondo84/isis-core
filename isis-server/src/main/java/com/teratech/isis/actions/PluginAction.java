package com.teratech.isis.actions;

import com.teratech.exceptions.ApplicationException;
import com.teratech.exceptions.ModelServiceException;
import com.teratech.actions.AbstractAction;
import com.teratech.actions.annotations.Action;
import com.teratech.actions.annotations.ActionMethod;
import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import com.teratech.metadata.ActionContextData;
import com.teratech.metadata.ActionData;
import com.teratech.model.PluginModel;
import com.teratech.model.cms.ActionType;
import com.teratech.services.MenuNodeService;
import com.teratech.services.PluginService;
import com.teratech.services.UserService;
import jakarta.xml.bind.JAXBException;
import org.apache.commons.lang.StringUtils;
import org.pf4j.PluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

import static com.teratech.utils.ApplicationConstans.Actions.*;

@Action
public class PluginAction extends AbstractAction {
    private static final Logger LOG = LoggerFactory.getLogger(PluginAction.class.getName());

    private final PluginService pluginService ;
    private final UserService userService;
    private final MenuNodeService menuNodeService;
    private final TransactionTemplate transactionTemplate;


    /**
     * @param pluginManager
     * @param flexibleSearch
     * @param persistenceManager
     * @param transactionTemplate
     */
    @Autowired
    protected PluginAction(PluginManager pluginManager, FlexibleSearch flexibleSearch, PersistenceManager persistenceManager, TransactionTemplate transactionTemplate, PluginService pluginService, UserService userService, MenuNodeService menuNodeService, TransactionTemplate transactionTemplate1) {
        super(pluginManager, flexibleSearch, persistenceManager, transactionTemplate);
        this.pluginService = pluginService;
        this.userService = userService;
        this.menuNodeService = menuNodeService;
        this.transactionTemplate = transactionTemplate1;
    }

    /**
     * Return all the plugin categories availables
     * @param context
     * @return
     * @throws ApplicationException
     */
    @ActionMethod(value = "categories", scope = ActionType.POST)
    public ActionContextData getPluginCategories(ActionContextData context) throws ApplicationException {
         try {
             context.put(DATA, pluginService.pluginCategories());
         } catch (Exception e) {
             throw new ApplicationException("500", e);
         }
         return context;
    }
    /**
     * Return all the plugins available for the connected user
     * @param context
     * @return
     * @throws ApplicationException
     */
    @ActionMethod(value = "session_plugins", scope = ActionType.POST)
    public ActionContextData getInstallPlugins (ActionContextData context) throws ApplicationException {

        try {
              // System.out.println("Connected with current-user : "+userService.getCurrentUser().getCode());
               context.put(DATA, pluginService.sessionPlugin(userService.getCurrentUser().getCode()));
        } catch (Exception e) {
            throw new ApplicationException("500", e);
        }
        return context;
    }

    @ActionMethod(value = "init", scope = ActionType.POST)
    public ActionContextData initialize(ActionContextData context) throws ApplicationException {
        try {
            String status =  pluginService.initialize();
            context.put(STATUS, status);

            return context;
        } catch (Exception e) {
            throw new ApplicationException("500", e);
        }
    }

    @ActionMethod(value = "refresh",  scope = ActionType.POST)
    public ActionContextData refresh (ActionContextData context) throws ModelServiceException {
        try {
            String status = pluginService.refresh();
            context.put(STATUS, status);
            return context;
        } catch (JAXBException | ModelServiceException | NoSuchFieldException | IllegalAccessException |
                 InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            throw new ModelServiceException(e);
        }
    }

    @ActionMethod(value = "reload", scope = ActionType.POST)
    public ActionContextData reload (ActionContextData context) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        Object data = context.get(DATA);

        if (Objects.isNull(data))
            throw new IllegalArgumentException("No data provided");

        PluginModel plugin = mapper.convertValue(data, PluginModel.class);
        transactionTemplate.setReadOnly(false);

        try {
            return transactionTemplate.execute(status -> {
                try {
                    menuNodeService.buildMenus(plugin);
                    return context;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (RuntimeException e) {
            throw new Exception(e);
        }

    }

    /**
     * Install
     * @param context
     * @return
     * @throws ModelServiceException
     */
    @ActionMethod(value = "install", scope = ActionType.POST)
    public ActionContextData install (ActionContextData context) throws ApplicationException {
        final String pluginId = (String) context.get(PLUGIN);

        if (StringUtils.isBlank(pluginId)) {
            throw new ApplicationException("500", String.format("No plugin found in the action context data"));
        }
        Boolean status =  pluginService.install(pluginId);
        context.put(STATUS, status.toString());
        return context;
    }

    /**
     *
     * @param context
     * @return
     * @throws ApplicationException
     */
    @ActionMethod(value = "uninstall", scope = ActionType.POST)
    public ActionContextData uninstall (ActionContextData context) throws ApplicationException, IllegalAccessException {
        final String pluginId = (String) context.get(PLUGIN);

        if (StringUtils.isBlank(pluginId)) {
            throw new ApplicationException("500", String.format("No plugin found in the action context data"));
        }
        Boolean status = pluginService.uninstall(pluginId);
        context.put(STATUS, status.toString());
        return context;
    }

    @ActionMethod(value = "load", scope = ActionType.POST)
    public ActionContextData loadPlugin (ActionContextData context) throws ApplicationException {

        try {
            final String pluginId = (String) context.get(PLUGIN);
            if (StringUtils.isBlank(pluginId)) {
                throw new ApplicationException("500", String.format("No plugin found in the action context data"));
            }
            context.put(DATA, pluginService.loadPlugin(pluginId)) ;
            return context;
        } catch (ApplicationException | ModelServiceException ex) {
            throw new ApplicationException("500", ex);
        }

    }
}
