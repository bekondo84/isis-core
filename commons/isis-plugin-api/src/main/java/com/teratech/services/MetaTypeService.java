package com.teratech.services;

import com.teratech.exceptions.ApplicationException;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import org.pf4j.PluginWrapper;

import java.util.Objects;

public interface MetaTypeService {

    /**
     * Load MetaTypeClasses et initialize
     * @param wrapper
     */
     void loadMetaTypeClasses (PluginWrapper wrapper) throws ApplicationException;

    /**
     * Delete all metatype for given plugin
     * @param wrapper
     * @throws ApplicationException
     */
     void cleanMetaTypesClasses(PluginWrapper wrapper) throws ApplicationException;
}
