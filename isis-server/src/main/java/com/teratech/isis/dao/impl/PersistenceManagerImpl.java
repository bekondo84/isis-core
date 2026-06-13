package com.teratech.isis.dao.impl;

import com.teratech.ModelServiceException;
import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import com.teratech.model.generic.ItemModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Repository
public class PersistenceManagerImpl implements PersistenceManager {

    @PersistenceContext
    private EntityManager em ;
    @Autowired
    private FlexibleSearch flexibleSearch;
    @Autowired
    private PluginManager pluginManager;

    /**
     * Save or update entity en transactional mode
     * @param entity
     */
    @Override
    public  <T extends ItemModel, S extends ItemModel>S save(T entity) throws IllegalAccessException, NoSuchFieldException {
        if (Objects.isNull(entity.getCreatedAt())) {
            //Check if the class inherit from ItemModel

            if (!ItemModel.class.isAssignableFrom(entity.getClass())) {
                throw new IllegalAccessException(String.format("Class %s don't inherited from %s", entity.getClass().getName(), ItemModel.class.getName()));
            }
            Class itemClass = getItemModelClass(entity.getClass());
            Field creatAt = itemClass.getDeclaredField("createdAt");
            creatAt.setAccessible(true);
            creatAt.set(entity, new Date());
            em.merge(entity);
        } else  {
            em.persist(entity);
        }
        return (S) flexibleSearch.find(entity);
    }

    /**
     * Get the IteùModel class
     * @param entityClazz
     * @return
     */
    private Class getItemModelClass(Class entityClazz) {
        Class itemClass = entityClazz ;

        while (!itemClass.equals(Object.class)) {
            itemClass = itemClass.getSuperclass();

            if (itemClass.equals(ItemModel.class))
                return itemClass;
        }
        return null;
    }
    /**
     * Save or update a list of entites in the same transactional model
     * @param entities
     */
    @Override
    public <T extends ItemModel> void save(T... entities) throws IllegalAccessException, NoSuchFieldException {
          for (T entity : entities) {
              save(entity);
          }
    }

    /**
     * Delete single entity in transactional mode
     *
     * @param entity
     */
    @Override
    public void delete(Object entity) throws ModelServiceException {

    }

    /**
     * Delete a list en entitie in the same transactional mode
     *
     * @param entities
     */
    @Override
    public void delete(Object... entities) throws ModelServiceException {

    }

    /**
     * Create new instance and attach it to the persistence context
     * so you can
     *
     * @param entityClass
     * @return
     */
    @Override
    public Object create(Class<?> entityClass) throws ModelServiceException {
        return null;
    }

    /**
     * Retrieve the entity instance base on the field mark as unique
     * So you must initialiwe those fields
     *
     * @param entity
     * @return
     */
    @Override
    public Object find(Object entity) throws ModelServiceException {
        return null;
    }

    /**
     * Retrieve the entity instance base on the field mark as unique
     * and return it as Json representation
     * So you must initialiwe those fields
     *
     * @param entity
     * @return
     */
    @Override
    public String findAndConvertToJson(Object entity) throws ModelServiceException {
        return "";
    }

    /**
     * Execute update and delete aueries
     *
     * @param query
     * @param parameters
     * @return
     */
    @Override
    public int executeUpdate(String query, Map<String, Object> parameters) {
        return 0;
    }

    /**
     * Flush the persistence context in the database
     */
    @Override
    public void flush() {

    }

    /**
     * Clear the persistence context
     * All entites states will be lost
     */
    @Override
    public void clear() {

    }
}
