package com.teratech;

import com.teratech.extensions.impl.AbstractPluginExtensionPointPoint;
import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Extension
public class PluginExtension extends AbstractPluginExtensionPointPoint {

    @Autowired
    protected PluginExtension(DataSource dataSource, ApplicationContext context) {
        super(dataSource, context);
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
