package com.teratech.isis.dao.impl;

import com.teratech.ModelServiceException;
import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import com.teratech.model.generic.AbstractTenant;
import com.teratech.model.generic.AbstractItem;
import com.teratech.utils.ClassUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.pf4j.PluginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.Date;
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
    public  <T extends AbstractItem, S extends AbstractItem>S save(T entity) throws ModelServiceException {
        //Check if the class inherit from ItemModel
        try {
            //Check if entity extends AbstractItem class and throw exception if not
            if (!AbstractItem.class.isAssignableFrom(entity.getClass()))
                throw new IllegalAccessException(String.format("Class %s don't inherited from %s", entity.getClass().getName(), AbstractItem.class.getName()));
            //Check if entity extends AbstractTenant and set the tenantId field
            if (isAssignableFrom(entity, AbstractTenant.class)) {
                //TODO
            }
            if (Objects.isNull(entity.getCreatedAt())) {
                setManagedField(AbstractItem.class, entity, "createdAt", LocalDateTime.now());
                em.persist(entity);
            } else  {
                setManagedField(AbstractItem.class, entity, "lastModif", LocalDateTime.now());
                em.merge(entity);
            }
            return (S) flexibleSearch.find(entity);
        } catch (IllegalAccessException | NoSuchFieldException | InstantiationException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new ModelServiceException(e);
        }

    }

    private <T extends AbstractItem> void setManagedField(Class clazz, T entity, String fieldname, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field field = ClassUtils.getFieldFrom(clazz, fieldname);

        if (Objects.nonNull(field)) {
            field.setAccessible(true);
            field.set(entity, value);
        }
    }


    /**
     * Save or update a list of entites in the same transactional model
     * @param entities
     */
    @Override
    public <T extends AbstractItem> void save(T... entities) throws ModelServiceException {
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
        try {
            em.remove(flexibleSearch.find((AbstractItem) entity));
        } catch (IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new ModelServiceException(e);
        }
    }

    /**
     * Delete a list en entitie in the same transactional mode
     *
     * @param entities
     */
    @Override
    public void delete(Object... entities) throws ModelServiceException {
            for (Object entity : entities) {
                delete(entity);
            }
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
        try {
            return entityClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new ModelServiceException(e);
        }
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

    /**
     *
     * @param entity
     * @param <T>
     * @throws IllegalAccessException
     */
    private static <T extends AbstractItem> boolean isAssignableFrom(T entity, Class type) throws IllegalAccessException {
        return type.isAssignableFrom(entity.getClass()) ;
    }
}
