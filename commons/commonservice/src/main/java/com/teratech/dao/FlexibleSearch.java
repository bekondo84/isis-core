package com.teratech.dao;

import com.teratech.model.generic.AbstractItem;
import com.teratech.tools.persistence.DAOUtilis;
import com.teratech.tools.persistence.RestrictionsContainer;
import jakarta.persistence.criteria.CriteriaQuery;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface FlexibleSearch {

    /**
     * Find entity of class clazz base
     * @param clazz
     * @param pk
     * @return
     */
    <T extends AbstractItem> T find(Class clazz, Object pk) ;
    /**
     * Find Object base on the entity unique field
     * @param entity
     * @return
     */
    <T extends AbstractItem> T find(final T entity) throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException;

    /**
     * Return Entities which macth the criteria set in the restriction container
     * @param container :container of predicate
     * @param orders : Result orders criteria
     * @param properties : Lazy properties to load
     * @param firstResult : first result
     * @param maxResult : max result
     * @return
     */
    List doSearch(final Class<? extends Object> entityClass , final RestrictionsContainer container , final Map<String , DAOUtilis.OrderType> orders , final Set<String> properties , int firstResult , int maxResult) throws IllegalAccessException;

    /**
     *  Return Entities which macth the criteria set in the restriction container
     * @param container:container of predicat
     * @param orders : Result orders criteria
     * @param properties : Lazy properties to load
     * @param hints :
     * @param firstResult: first result
     * @param maxResult : max result
     * @return
     */
    List doSearch(final Class<? extends Object> entityClass , final RestrictionsContainer container , final Map<String , DAOUtilis.OrderType> orders , final Set<String> properties , final Map<String , Object> hints , int firstResult , int maxResult) throws IllegalAccessException;

    /**
     * Execute criteriq Query
     * @param criteriaQuery : Criteria Query
     * @param parameters : Map of parameters
     * @return
     */
    List doSearch(final CriteriaQuery<? extends Object> criteriaQuery , final Map<String , Object> parameters) throws IllegalAccessException;

    /**
     * Execute Query base on Query
     * @param queryString : Query String
     * @param parameters : Map of parameters
     * @return
     */
    List doSearch(final String queryString ,  final Map<String , Object> parameters) throws IllegalAccessException;
    /**
     * Number of entities which match the criteria
     * @param container
     * @return
     */
    long count(final Class<? extends Object> entityClass , final RestrictionsContainer container);

    /**
     * MetaTypeModel of given typeCode
     * @param typeCode
     * @return
     */
   // MetaTypeModel getMetaType(String typeCode) ;
}
