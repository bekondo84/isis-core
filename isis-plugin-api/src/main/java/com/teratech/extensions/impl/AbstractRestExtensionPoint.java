package com.teratech.extensions.impl;

import com.teratech.extensions.RestExtensionPoint;
import com.teratech.jaxb.controller.Controllers;
import com.teratech.services.JAXBService;
import com.teratech.services.impl.JAXBServiceImpl;
import jakarta.xml.bind.JAXBException;
import org.pf4j.PluginWrapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class AbstractRestExtensionPoint implements RestExtensionPoint {

    private JAXBService jaxbService;


    /**
     *
     */
    public AbstractRestExtensionPoint() {
        jaxbService = new JAXBServiceImpl();
    }

    /**
     *
     * @param jaxbService
     */
    public AbstractRestExtensionPoint(JAXBService jaxbService) {
        this.jaxbService = jaxbService;
    }

    /**
     * Return the List of All RestController of the plugin
     *
     * @return
     */
    @Override
    public List getRestController() throws JAXBException {

        //Get Controller declares
        Controllers controllers = jaxbService.getControllerFromResources();
        System.out.println("-----getRestController -----------------");
       return controllers.getController().stream().map(ctr -> {
            Object bean = null ;
            try {
                bean = getContext().getBean(ctr.getName())   ;
                //System.out.println(bean);
            } catch (BeansException ex) {
                ex.printStackTrace();
            }
            return bean;
        }).filter(Objects::nonNull)
           .filter(bean -> bean.getClass().isAnnotationPresent(RestController.class)).collect(Collectors.toList());
    }

    /**
     * @param wrapper
     * @return
     * @throws JAXBException
     */
    @Override
    public List getRestController(PluginWrapper wrapper) throws JAXBException {
        //Get Controller declares
        Controllers controllers = jaxbService.getControllerFromResources(wrapper);
        System.out.println("-----getRestController -----------------");
        return controllers.getController().stream().map(ctr -> {
                    Object bean = null ;
                    try {
                        Class clazz =  wrapper.getPluginClassLoader().loadClass(ctr.getName());
                        System.out.println("-----------------Bean def list -------------------- "+getContext().getBeanDefinitionNames());
                        bean = getContext().getBean(clazz)   ;
                        //System.out.println(bean);
                    } catch (BeansException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    return bean;
                }).filter(Objects::nonNull)
                .filter(bean -> bean.getClass().isAnnotationPresent(RestController.class)).collect(Collectors.toList());
    }

    /**
     *
     * @param jaxbService
     */
    public void setJaxbService(JAXBService jaxbService) {
        this.jaxbService = jaxbService;
    }
}
