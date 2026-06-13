package com.teratech;

import com.teratech.extensions.impl.AbstractPluginExtensionPointPoint;
import com.teratech.services.PluginService;
import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

//@Component
@Extension
public class PluginExtension extends AbstractPluginExtensionPointPoint {

    @Autowired
    protected PluginExtension(DataSource dataSource, ApplicationContext context, PluginService pluginService) {
        super(dataSource, context, pluginService);
    }

    /**
     * List of sql files name in the sub repository sql
     *
     * @return
     */
    @Override
    public String[] sqlFilesPath() {
        return super.sqlFilesPath();
    }
}
