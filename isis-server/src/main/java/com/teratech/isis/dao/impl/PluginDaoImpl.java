package com.teratech.isis.dao.impl;

import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import com.teratech.isis.dao.PluginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PluginDaoImpl implements PluginDao {
    @Autowired
    private FlexibleSearch flexibleSearch;
    @Autowired
   private PersistenceManager persistenceManager;

    /**
     * @return
     */
    @Override
    public FlexibleSearch getFlexibleSearch() {
        return flexibleSearch;
    }

    /**
     * @return
     */
    @Override
    public PersistenceManager getPersistenceManager() {
        return persistenceManager;
    }


}
