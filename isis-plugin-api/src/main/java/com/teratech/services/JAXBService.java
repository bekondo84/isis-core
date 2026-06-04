package com.teratech.services;

import com.teratech.jaxb.controller.Controllers;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.pf4j.PluginWrapper;

import java.io.File;
import java.io.InputStream;

public interface JAXBService {

    String SCHEMA_CONTROLLERS_XML = "schema/controllers.xml";

    default Controllers getControllerFromResources(PluginWrapper wrapper) throws JAXBException {
        ClassLoader pluginClassLoader = wrapper.getPluginClassLoader();
        InputStream inputStream = pluginClassLoader.getResourceAsStream(SCHEMA_CONTROLLERS_XML);
        //System.out.println(String.format("InputStream :::::::::::::::::::::::::::::: %s :::::::::: %s", inputStream, pluginClassLoader.getResource(SCHEMA_CONTROLLERS_XML)));
        return getFrom(inputStream);
    }

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
