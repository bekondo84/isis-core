package com.teratech.services;

import com.teratech.jaxb.entities.Controllers;
import com.teratech.jaxb.entities.Plugin;
import com.teratech.jaxb.entities.Services;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.pf4j.PluginWrapper;

import java.io.InputStream;

public interface JAXBService {

    String SCHEMA_CONTROLLERS_XML = "schema/controllers.xml";
    String SCHEMA_SERVICES_XML = "schema/services.xml";
    String SCHEMA_PLUGIN_XML = "schema/plugin.xml";


    /**
     *
     * @param wrapper
     * @return plugin informations
     * @throws JAXBException
     */
    default Plugin getPluginFromResources(PluginWrapper wrapper) throws JAXBException {
        ClassLoader pluginClassLoader = wrapper.getPluginClassLoader();
        InputStream inputStream = pluginClassLoader.getResourceAsStream(SCHEMA_PLUGIN_XML);
        System.out.println(String.format("InputStream :::::::::::::::::::::::::::::: %s :::::::::: %s", inputStream, pluginClassLoader.getResource(SCHEMA_CONTROLLERS_XML)));
        JAXBContext context = JAXBContext.newInstance(Plugin.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Plugin plugin = (Plugin) unmarshaller.unmarshal(inputStream);
        return plugin;
    }

    /**
     *
     * @param wrapper
     * @return declare serives from services.xml
     * @throws JAXBException
     */
    default Services getServiceFromResources(PluginWrapper wrapper) throws JAXBException {
        ClassLoader pluginClassLoader = wrapper.getPluginClassLoader();
        InputStream inputStream = pluginClassLoader.getResourceAsStream(SCHEMA_SERVICES_XML);
        //System.out.println(String.format("InputStream :::::::::::::::::::::::::::::: %s :::::::::: %s", inputStream, pluginClassLoader.getResource(SCHEMA_CONTROLLERS_XML)));
        JAXBContext context = JAXBContext.newInstance(Services.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Services services = (Services) unmarshaller.unmarshal(inputStream);
        return services;
    }

    /**
     *
     * @param wrapper
     * @return Controllers from controllers.xml file
     * @throws JAXBException
     */
    default Controllers getControllerFromResources(PluginWrapper wrapper) throws JAXBException {
        ClassLoader pluginClassLoader = wrapper.getPluginClassLoader();
        InputStream inputStream = pluginClassLoader.getResourceAsStream(SCHEMA_CONTROLLERS_XML);
        //System.out.println(String.format("InputStream :::::::::::::::::::::::::::::: %s :::::::::: %s", inputStream, pluginClassLoader.getResource(SCHEMA_CONTROLLERS_XML)));
        return getFrom(inputStream);
    }

    /**
     *
     * @return
     * @throws JAXBException
     */
    default Controllers getControllerFromResources() throws JAXBException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(SCHEMA_CONTROLLERS_XML);
        System.out.println(String.format("InputStream :::::::::::::::::::::::::::::: %s :::::::::: %s", inputStream, JAXBService.class.getResource(SCHEMA_CONTROLLERS_XML)));
        return getFrom(inputStream);
    }



    /**
     *
     * @param inputStream
     * @return
     * @throws JAXBException
     */
    default Controllers getFrom(InputStream inputStream) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Controllers.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Controllers controllers = (Controllers) unmarshaller.unmarshal(inputStream);
        return controllers;
    }
}
