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
import jakarta.xml.bind.JAXBException;
import org.apache.commons.lang.StringUtils;
import org.pf4j.PluginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.IOException;

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
    public String initialize(ActionContextData context) throws ModelServiceException {
        try {
            return pluginService.initialize();
        } catch (JAXBException | IllegalAccessException | ModelServiceException | IOException | NoSuchFieldException |
                 InstantiationException e) {
            throw new ModelServiceException(e);
        }
    }

    @ActionMethod(value = "refresh",  scope = ActionType.POST)
    public String refresh (ActionContextData context) throws ModelServiceException {
        try {
            return pluginService.refresh();
        } catch (JAXBException | ModelServiceException | NoSuchFieldException | IllegalAccessException |
                 InstantiationException e) {
            throw new ModelServiceException(e);
        }
    }

    @ActionMethod(value = "install", scope = ActionType.POST)
    public Boolean install (ActionContextData context) throws ModelServiceException {
        final String pluginId = (String) context.get(ApplicationConstans.Actions.DATA);
        assert  StringUtils.isNotBlank(pluginId) : String.format("No plugin found in the action context data");
        try {
            return  pluginService.isInstall(pluginId);
        } catch (NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            throw new ModelServiceException(e);
        }
    }
}
