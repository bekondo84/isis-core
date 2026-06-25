package com.teratech.extensions;

import jakarta.xml.bind.JAXBException;
import org.pf4j.PluginWrapper;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface PluginExtensionPoint extends IsisExtensionPoint{

    /***
     * Single Extension Point per plugin for install plugin settings
     * @return
     */
    boolean install(PluginWrapper wrapper) throws IOException, JAXBException, NoSuchFieldException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException;

    /**
     * List of sql files name in the sub repository sql
     * @return
     */
    default String[] sqlFilesPath() {
        return new String[] {};
    }
}
