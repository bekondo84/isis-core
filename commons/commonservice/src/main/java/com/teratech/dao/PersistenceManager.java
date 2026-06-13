package com.teratech.dao;

import com.teratech.ModelServiceException;
import com.teratech.model.generic.ItemModel;

import java.util.Map;

public interface PersistenceManager {
    /**
     * Save or update entity en transactional mode
     * @param entity
     */
    <T extends ItemModel, S extends ItemModel> S save(T entity) throws ModelServiceException, IllegalAccessException, NoSuchFieldException;

    /**
     * Save or update a list of entites in the same transactional model
     * @param entities
     */
    <T extends ItemModel> void save(T ... entities) throws ModelServiceException, IllegalAccessException, NoSuchFieldException;

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
     * Retrieve the entity instance base on the field mark as unique
     * So you must initialiwe those fields
     * @param entity
     * @return
     */
    Object find(Object entity) throws  ModelServiceException;

    /**
     * Retrieve the entity instance base on the field mark as unique
     * and return it as Json representation
     * So you must initialiwe those fields
     * @param entity
     * @return
     */
    String findAndConvertToJson(Object entity) throws ModelServiceException;
    /**
     * Execute update and delete aueries
     * @param query
     * @param parameters
     * @return
     */
    int executeUpdate(final String query , final Map<String , Object> parameters);
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
