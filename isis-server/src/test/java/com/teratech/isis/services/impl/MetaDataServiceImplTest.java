package com.teratech.isis.services.impl;

import com.teratech.metadata.MetaData;
import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.*;

class MetaDataServiceImplTest extends MetaDataServiceImpl{

    @BeforeEach
    void setUp() {
    }

    @Test
    void createMetaForCompanyTemplate() throws JAXBException {
        MetaData meta = buildMetaDataFrom(CompanyTest.class, null, "company.xml", true);
        assertNotNull(meta);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(meta));
    }
}