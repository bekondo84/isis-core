package com.teratech.extensions;

import jakarta.xml.bind.JAXBException;
import org.pf4j.ExtensionPoint;
import org.pf4j.PluginWrapper;

import java.util.List;

/**
 * This ExtensionPoint expose RestController component for givin plugin
 */
public interface RestExtensionPoint extends IsisExtensionPoint {

    /**
     * Return the List of All RestController of the plugin
     * @return
     */
    List getRestController() throws JAXBException;

    List getRestController(PluginWrapper wrapper) throws JAXBException;


}
