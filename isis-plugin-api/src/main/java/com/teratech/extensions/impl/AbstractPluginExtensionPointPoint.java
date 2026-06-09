package com.teratech.extensions.impl;

import com.teratech.extensions.PluginExtensionPoint;
import org.pf4j.PluginWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.io.IOException;

public abstract class AbstractPluginExtensionPointPoint implements PluginExtensionPoint {

    protected final DataSource dataSource;
    protected final ApplicationContext context;

    protected AbstractPluginExtensionPointPoint(DataSource dataSource, ApplicationContext context) {
        this.dataSource = dataSource;
        this.context = context;
    }

    /***
     * Single Extension Point per plugin for install plugin settings
     * @return
     */
    @Override
    public boolean install(PluginWrapper wrapper) throws IOException {

        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        final String[] sqlFiles = sqlFilesPath();
        if (sqlFiles != null) {
             for (String sqlFile : sqlFiles) {
                 populator.addScript(new ClassPathResource("/sql/"+sqlFile, wrapper.getPluginClassLoader()));
             }
             populator.execute(dataSource);
        }
       // populator.
        return false;
    }

    /**
     * @return the current plugin name
     */
    @Override
    public String plugin() {
        return "";
    }

    /**
     * Return the spring application context
     *
     * @return
     */
    @Override
    public ApplicationContext getContext() {
        return context;
    }
}
