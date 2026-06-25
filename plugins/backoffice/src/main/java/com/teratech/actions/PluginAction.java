package com.teratech.actions;

import com.teratech.ModelServiceException;
import com.teratech.actions.annotations.Action;
import com.teratech.actions.annotations.ActionMethod;
import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import com.teratech.metadata.ActionContextData;
import com.teratech.model.cms.ActionType;
import com.teratech.services.PluginService;
import com.teratech.utils.ApplicationConstans;
import com.teratech.utils.ApplicationConstans.Actions;
import jakarta.xml.bind.JAXBException;
import org.apache.commons.lang.StringUtils;
import org.pf4j.PluginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static com.teratech.utils.ApplicationConstans.Actions.*;

@Action
public class PluginAction extends AbstractAction{

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

    @ActionMethod(value = "install", scope = ActionType.POST)
    public ActionContextData install (ActionContextData context) throws ModelServiceException {
        final String pluginId = (String) context.get(DATA);
        assert  StringUtils.isNotBlank(pluginId) : String.format("No plugin found in the action context data");
        try {
            Boolean status =  pluginService.isInstall(pluginId);
            context.put(STATUS, status.toString());
            return context;
        } catch (NoSuchFieldException | IllegalAccessException | InstantiationException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new ModelServiceException(e);
        }
    }
}
