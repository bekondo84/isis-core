package com.teratech.extensions.impl;

import com.teratech.jaxb.controller.Controllers;
import com.teratech.services.JAXBService;
import jakarta.xml.bind.JAXBException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class ControllerExtensionPointTest extends AbstractControllerExtensionPoint {

    private JAXBService jaxbService;
    private ApplicationContext context ;

    @Before
    public void setUp() throws Exception {
        jaxbService = Mockito.mock(JAXBService.class);
        context = Mockito.mock(ApplicationContext.class) ;
    }

    /**
     * Return the spring application context
     *
     * @return
     */
    @Override
    public ApplicationContext getContext() {
        return context;
    }

    /**
     * @return the current plugin name
     */
    @Override
    public String plugin() {
        return "";
    }

    @Test
    public void testGetRestController() throws JAXBException {
           setJaxbService(jaxbService);
           Controllers controllers = new Controllers();
           Controllers.Controller controller = new Controllers.Controller();
           controller.setName("bean01");
           controllers.getController().add(controller);
           controller = new Controllers.Controller();
           controller.setName("bean02");
           controllers.getController().add(controller);
           Mockito.when(jaxbService.getControllerFromResources()).thenReturn(controllers);
           Mockito.when(getContext().getBean("bean01")).thenReturn(new TestController01());
           Mockito.when(getContext().getBean("bean02")).thenReturn(null);
           List values = getRestController();
           assertTrue(values != null && !values.isEmpty());
           assertTrue(values.size() == 1);
    }
}