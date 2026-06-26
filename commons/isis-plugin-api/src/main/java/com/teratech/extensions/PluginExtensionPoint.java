package com.teratech.extensions;

import com.teratech.exceptions.ApplicationException;
import com.teratech.exceptions.ModelServiceException;
import jakarta.xml.bind.JAXBException;
import org.pf4j.PluginWrapper;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface PluginExtensionPoint extends IsisExtensionPoint{

    /***
     * Single Extension Point per plugin for install plugin settings
     * @return
     */
    boolean install(PluginWrapper wrapper)  throws ApplicationException;

    boolean uninstall(PluginWrapper wrapper)  throws ApplicationException ;
    /**
     * List of sql files to execute when install plugin
     * @return
     */
    default String[] installSqlFiles() {
        return new String[] {};
    }

    /**
     * List of sql files to execute when uninstall plugin
     * @return
     */
    default String[] uninstallSqlFiles() {
        return new String[] {};
    }
}
