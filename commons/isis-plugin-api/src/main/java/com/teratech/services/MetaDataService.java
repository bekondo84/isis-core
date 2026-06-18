package com.teratech.services;

import com.teratech.metadata.MetaData;
import com.teratech.metadata.NavigationLinkData;
import jakarta.xml.bind.JAXBException;
import org.pf4j.PluginWrapper;

public interface MetaDataService {

    /**
     * Build MetaData From Class definition
     * @param clazz
     * @param wrapper
     * @param templatename
     * @param principal : IF TRUE BUILD the complete metadata else partially build the metadata
     * @return
     */
    MetaData buildMetaDataFrom(Class clazz, PluginWrapper wrapper, String templatename, boolean principal) throws JAXBException;

    /**
     *  Build MetaData From Navigation Node
     * @param navNode
     * @param pluginid
     * @return
     * @throws ClassNotFoundException
     * @throws JAXBException
     */
    MetaData buildMetaDataFrom (NavigationLinkData navNode, String pluginid) throws ClassNotFoundException, JAXBException;
}
