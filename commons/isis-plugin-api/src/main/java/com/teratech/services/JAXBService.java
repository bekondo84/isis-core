package com.teratech.services;

import com.teratech.jaxb.entities.*;
import com.teratech.utils.ApplicationConstans;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.commons.lang.StringUtils;
import org.pf4j.PluginWrapper;

import java.io.InputStream;
import java.util.Objects;

import static com.teratech.utils.ApplicationConstans.CMS.*;

public interface JAXBService {


    /**
     *
     * @param wrapper
     * @return plugin informations
     * @throws JAXBException
     */
    default Context getTemplateFromResources(PluginWrapper wrapper, String template) throws JAXBException {

        if (StringUtils.isBlank(template))
            return null;

        ClassLoader pluginClassLoader = Thread.currentThread().getContextClassLoader();
        if (Objects.nonNull(wrapper)) {
            pluginClassLoader = wrapper.getPluginClassLoader();
        }

        InputStream inputStream = pluginClassLoader.getResourceAsStream(ApplicationConstans.CMS.SCHEMA_TEMPLATE_XML +template);

        if (Objects.isNull(inputStream))
            return null;
        System.out.println(String.format("InputStream :::::::::::::::::::::::::::::: %s :::::::::: %s", inputStream, pluginClassLoader.getResource(SCHEMA_TEMPLATE_XML+template)));
        JAXBContext context = JAXBContext.newInstance(Context.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Context) unmarshaller.unmarshal(inputStream);
    }

    /**
     *
     * @param wrapper
     * @return plugin informations
     * @throws JAXBException
     */
    default ExplorerTree getExplorerFromResources(PluginWrapper wrapper) throws JAXBException {
        ClassLoader pluginClassLoader = wrapper.getPluginClassLoader();
        InputStream inputStream = pluginClassLoader.getResourceAsStream(ApplicationConstans.CMS.SCHEMA_EXPLORER_XML);
        //System.out.println(String.format("InputStream :::::::::::::::::::::::::::::: %s :::::::::: %s", inputStream, pluginClassLoader.getResource(SCHEMA_CONTROLLERS_XML)));
        JAXBContext context = JAXBContext.newInstance(ExplorerTree.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (ExplorerTree) unmarshaller.unmarshal(inputStream);
    }
    /**
     *
     * @param wrapper
     * @return plugin informations
     * @throws JAXBException
     */
    default Plugin getPluginFromResources(PluginWrapper wrapper) throws JAXBException {
        ClassLoader pluginClassLoader = wrapper.getPluginClassLoader();
        InputStream inputStream = pluginClassLoader.getResourceAsStream(SCHEMA_PLUGIN_XML);
        //System.out.println(String.format("InputStream :::::::::::::::::::::::::::::: %s :::::::::: %s", inputStream, pluginClassLoader.getResource(SCHEMA_CONTROLLERS_XML)));
        JAXBContext context = JAXBContext.newInstance(Plugin.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Plugin) unmarshaller.unmarshal(inputStream);
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
        return (Services) unmarshaller.unmarshal(inputStream);
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
