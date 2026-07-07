package com.teratech.isis.actions;

import com.teratech.actions.AbstractAction;
import com.teratech.actions.annotations.Action;
import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import org.pf4j.PluginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;

@Action("cronJobAction")
public class CronJobAction extends AbstractAction {
    /**
     * @param pluginManager
     * @param flexibleSearch
     * @param persistenceManager
     * @param transactionTemplate
     */
    @Autowired
    protected CronJobAction(PluginManager pluginManager, FlexibleSearch flexibleSearch, PersistenceManager persistenceManager, TransactionTemplate transactionTemplate) {
        super(pluginManager, flexibleSearch, persistenceManager, transactionTemplate);
    }


}
