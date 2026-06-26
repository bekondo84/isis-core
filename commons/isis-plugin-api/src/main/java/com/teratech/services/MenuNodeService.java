package com.teratech.services;

import com.teratech.exceptions.ModelServiceException;
import jakarta.xml.bind.JAXBException;
import org.pf4j.PluginWrapper;

import java.lang.reflect.InvocationTargetException;

public interface MenuNodeService {
     static final String RESET_MENU_PARENT_QUERY = "UPDATE AbstractMenu AS m SET m.parent = NULL WHERE m.plugin.id = :plugin AND m.plugin.version = :version";
     static final String DELETE_MENU_QUERY = "DELETE FROM AbstractMenu AS m WHERE  m.plugin.id = :plugin AND m.plugin.version = :version";

     /**
     * Build plugin navigation nodes
     * @param wrapper
     * @return
     */
     void buildMenus (PluginWrapper wrapper) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, JAXBException, ModelServiceException;

     /**
      *
      * @param wrapper
      */
     void cleanPluginMenus (PluginWrapper wrapper) ;
}
