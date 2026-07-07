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
import com.teratech.model.cms.ActionType;
import com.teratech.services.PluginService;
import jakarta.xml.bind.JAXBException;
import org.apache.commons.lang.StringUtils;
import org.pf4j.PluginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static com.teratech.utils.ApplicationConstans.Actions.*;

@Action
public class PluginAction extends AbstractAction {

    private final PluginService pluginService ;
    /**
     * @param pluginManager
     * @param flexibleSearch
     * @param persistenceManager
     * @param transactionTemplate
     */
    @Autowired
    protected PluginAction(PluginManager pluginManager, FlexibleSearch flexibleSearch, PersistenceManager persistenceManager, TransactionTemplate transactionTemplate, PluginService pluginService) {
        super(pluginManager, flexibleSearch, persistenceManager, transactionTemplate);
        this.pluginService = pluginService;
    }

    @ActionMethod(value = "init", scope = ActionType.POST)
    public ActionContextData initialize(ActionContextData context) throws ModelServiceException {
        try {
            String status =  pluginService.initialize();
            context.put(STATUS, status);

            return context;
        } catch (JAXBException | IllegalAccessException | ModelServiceException | IOException | NoSuchFieldException |
                 InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            throw new ModelServiceException(e);
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
            throw new ApplicationException(String.format("No plugin found in the action context data"));
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
            throw new ApplicationException(String.format("No plugin found in the action context data"));
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
                throw new ApplicationException(String.format("No plugin found in the action context data"));
            }
            context.put(DATA, pluginService.loadPlugin(pluginId)) ;
            return context;
        } catch (ApplicationException | ModelServiceException ex) {
            throw new ApplicationException(ex);
        }

    }
}
