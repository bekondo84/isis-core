package com.teratech.isis.dao.impl;

import com.teratech.isis.dao.PluginDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class PluginDaoImpl implements PluginDao {

    @PersistenceContext
    private EntityManager em ;

    /**
     * @return
     */
    @Override
    public EntityManager getEm() {
        return em;
    }
}
