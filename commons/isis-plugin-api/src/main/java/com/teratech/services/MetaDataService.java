package com.teratech.services;

import com.teratech.metadata.MetaData;
import com.teratech.model.cms.MenuItemModel;
import com.teratech.model.cms.MetaTypeModel;
import jakarta.xml.bind.JAXBException;
import org.pf4j.PluginWrapper;

import java.lang.reflect.InvocationTargetException;

public interface MetaDataService {

    /**
     * Build MetaData From Class definition
     * @param clazz
     * @param wrapper
     * @param templatename
     * @param principal : IF TRUE BUILD the complete metadata else partially build the metadata
     * @return
     */
    MetaData buildMetaDataFrom(Class clazz, PluginWrapper wrapper, String templatename, boolean principal) throws JAXBException;

    /**
     *  Build MetaData From Navigation Node
     * @param menuItem
     * @return
     * @throws ClassNotFoundException
     * @throws JAXBException
     */
    MetaData buildMetaDataFrom (MenuItemModel menuItem) throws ClassNotFoundException, JAXBException, IllegalAccessException, NoSuchFieldException, InstantiationException, InvocationTargetException, NoSuchMethodException;

    /**
     *  Build MetaData From Navigation Node
     * @param metaType
     * @return
     * @throws ClassNotFoundException
     * @throws JAXBException
     */
    MetaData buildMetaDataFrom (MetaTypeModel metaType) throws ClassNotFoundException, JAXBException, IllegalAccessException, NoSuchFieldException, InstantiationException;


}
