package com.teratech.extensions.impl;

import com.teratech.extensions.ControllerExtensionPoint;
import com.teratech.jaxb.entities.Controllers;
import com.teratech.services.JAXBService;
import com.teratech.services.impl.JAXBServiceImpl;
import jakarta.xml.bind.JAXBException;
import org.pf4j.PluginWrapper;
import org.springframework.beans.BeansException;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class AbstractControllerExtensionPoint implements ControllerExtensionPoint {

    private JAXBService jaxbService;


    /**
     *
     */
    public AbstractControllerExtensionPoint() {
        jaxbService = new JAXBServiceImpl();
    }

    /**
     *
     * @param jaxbService
     */
    public AbstractControllerExtensionPoint(JAXBService jaxbService) {
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
        return controllers.getController().stream().map(ctr -> {
                    Object bean = null ;
                    try {
                        Class clazz =  wrapper.getPluginClassLoader().loadClass(ctr.getName());
                        bean = getContext().getBean(clazz)   ;
                    } catch (BeansException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    return bean;
                }).filter(Objects::nonNull)
                /*.filter(bean -> bean.getClass().isAnnotationPresent(RestController.class) || bean.getClass().isAnnotationPresent(CON.class))*/
                .collect(Collectors.toList());
    }

    /**
     *
     * @param jaxbService
     */
    public void setJaxbService(JAXBService jaxbService) {
        this.jaxbService = jaxbService;
    }
}
