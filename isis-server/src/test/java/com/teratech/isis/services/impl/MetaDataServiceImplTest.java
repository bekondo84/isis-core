package com.teratech.isis.services.impl;

import com.teratech.dao.FlexibleSearch;
import com.teratech.isis.dao.impl.FlexibleSearchImpl;
import com.teratech.metadata.MetaData;
import com.teratech.services.I18NService;
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
    private I18NService i18NService;

    @BeforeEach
    void setUp() {
        pluginManager = Mockito.mock(PluginManager.class);
        flexibleSearch = Mockito.mock(FlexibleSearchImpl.class);
        i18NService = Mockito.mock(I18NServiceImpl.class);
        metaDataService = new MetaDataServiceImpl(pluginManager, flexibleSearch, i18NService);
    }

    @Test
    void createMetaForCompanyTemplate() throws JAXBException {
        MetaData meta = metaDataService.buildMetaDataFrom(CompanyTest.class, null, "company.xml", true);
        assertNotNull(meta);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(meta));
    }
}