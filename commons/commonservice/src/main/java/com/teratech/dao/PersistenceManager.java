package com.teratech.dao;

import com.teratech.ModelServiceException;
import com.teratech.model.generic.AbstractItem;

public interface PersistenceManager {
    /**
     * Save or update entity en transactional mode
     * @param entity
     */
    <T extends AbstractItem, S extends AbstractItem> S save(T entity) throws ModelServiceException, IllegalAccessException, NoSuchFieldException;

    /**
     * Save or update a list of entites in the same transactional model
     * @param entities
     */
    <T extends AbstractItem> void save(T ... entities) throws ModelServiceException, IllegalAccessException, NoSuchFieldException;

    /**
     * Delete single entity in transactional mode
     * @param entity
     */
    void delete(Object entity) throws ModelServiceException;

    /**
     * Delete a list en entitie in the same transactional mode
     * @param entities
     */
    void delete(Object ... entities) throws ModelServiceException;


    /**
     * Create new instance and attach it to the persistence context
     * so you can
     * @param entityClass
     * @return
     */
    Object create(Class<?> entityClass) throws ModelServiceException;

    /**
     * Flush the persistence context in the database
     */
    void flush();

    /**
     * Clear the persistence context
     * All entites states will be lost
     */
    void clear();

}
