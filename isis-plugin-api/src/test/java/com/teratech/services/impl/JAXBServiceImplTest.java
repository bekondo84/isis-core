package com.teratech.services.impl;

import com.teratech.jaxb.controller.Controllers;
import com.teratech.services.JAXBService;
import jakarta.xml.bind.JAXBException;
import junit.framework.TestCase;

import java.io.InputStream;
import java.util.Objects;

public class JAXBServiceImplTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }


    public void testGetControllerFromResources() throws JAXBException {

        JAXBService jaxbService = new JAXBServiceImpl();
        Controllers controllers = jaxbService.getControllerFromResources();
        assertNotNull(controllers);
        assertEquals(controllers.getController().size(), 3);
    }
}