package com.teratech.isis.actions;

import com.teratech.actions.AbstractAction;
import com.teratech.actions.annotations.Action;
import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import com.teratech.utils.ApplicationConstans.Actions;
import org.pf4j.PluginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;

@Action(Actions.DEFAULT_ACTION)
public class DefaultAction extends AbstractAction {

    /**
     * @param pluginManager
     */
    @Autowired
    public DefaultAction(PluginManager pluginManager, FlexibleSearch flexibleSearch, PersistenceManager persistenceManager, TransactionTemplate transactionTemplate) {
        super(pluginManager, flexibleSearch, persistenceManager, transactionTemplate);
    }
}
