package com.teratech.isis.services.impl;

import com.teratech.dao.FlexibleSearch;
import com.teratech.isis.dao.impl.FlexibleSearchImpl;
import com.teratech.metadata.MetaData;
import com.teratech.services.MetaDataService;
import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.pf4j.PluginManager;
import tools.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.*;

class MetaDataServiceImplTest {

    private MetaDataService metaDataService ;
    private PluginManager pluginManager;
    private FlexibleSearch flexibleSearch;

    @BeforeEach
    void setUp() {
        pluginManager = Mockito.mock(PluginManager.class);
        flexibleSearch = Mockito.mock(FlexibleSearchImpl.class);
        metaDataService = new MetaDataServiceImpl(pluginManager, flexibleSearch);
    }

    @Test
    void createMetaForCompanyTemplate() throws JAXBException {
        MetaData meta = metaDataService.buildMetaDataFrom(CompanyTest.class, null, "company.xml", true);
        assertNotNull(meta);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(meta));
    }
}