package com.teratech.extensions;

import org.pf4j.PluginWrapper;

import java.io.IOException;

public interface PluginExtensionPoint extends IsisExtensionPoint{

    /***
     * Single Extension Point per plugin for install plugin settings
     * @return
     */
    boolean install(PluginWrapper wrapper) throws IOException;

    /**
     * List of sql files name in the sub repository sql
     * @return
     */
    default String[] sqlFilesPath() {
        return new String[] {"create.sql", "update.sql"};
    }
}
