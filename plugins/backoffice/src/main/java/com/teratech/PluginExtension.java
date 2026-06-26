package com.teratech;

import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import com.teratech.extensions.impl.AbstractPluginExtensionPointPoint;
import com.teratech.services.MenuNodeService;
import com.teratech.services.PluginService;
import org.pf4j.Extension;
import org.pf4j.PluginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Component
@Extension
public class PluginExtension extends AbstractPluginExtensionPointPoint {


    @Autowired
    protected PluginExtension(DataSource dataSource, ApplicationContext context, FlexibleSearch flexibleSearch, MenuNodeService menuNodeService, PersistenceManager persistenceManager, PluginManager pluginManager, TransactionTemplate transactionTemplate) {
        super(dataSource, context, flexibleSearch, menuNodeService, persistenceManager, pluginManager, transactionTemplate);
    }

    /**
     * List of sql files name in the sub repository sql
     *
     * @return
     */
    @Override
    public String[] installSqlFiles() {
        return super.installSqlFiles();
    }
}
