package com.teratech.isis.dao.impl;

import com.teratech.dao.FlexibleSearch;
import com.teratech.tools.persistence.DAOUtilis;
import com.teratech.tools.persistence.EQ;
import com.teratech.tools.persistence.Predicat;
import com.teratech.tools.persistence.RestrictionsContainer;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

import static com.teratech.tools.persistence.DAOUtilis.*;

@Repository
public class FlexibleSearchImpl implements FlexibleSearch {

    @PersistenceContext
    private EntityManager em ;

    /**
     * @param clazz
     * @return
     */
    @Override
    public Object find(Class clazz, RestrictionsContainer container) {
        final CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        final CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(clazz);
        final Root<?> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.and(container.getPredicats().stream().map(pred -> pred.generateJPAPredicat(criteriaBuilder, root)).collect(Collectors.toList())));

        TypedQuery<?> query = em.createQuery(criteriaQuery);
        return query.getSingleResultOrNull();
    }


    /**
     * Find Object base on the entity unique field
     *
     * @param entity
     * @return
     */
    @Override
    public Object find(Object entity) throws IllegalAccessException {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        Field[] fields = entity.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Id.class)) {
                if (String.class.isAssignableFrom(field.getType())) {
                    container.addEq(field.getName(), (String)field.get(entity));
                } else if (Integer.class.isAssignableFrom(field.getType())) {
                    container.addEq(field.getName(), (Integer)field.get(entity));
                } else if (Short.class.isAssignableFrom(field.getType())) {
                    container.addEq(field.getName(), (Short)field.get(entity));
                } else if (Long.class.isAssignableFrom(field.getType())) {
                    container.addEq(field.getName(), (Long)field.get(entity));
                } else if (Float.class.isAssignableFrom(field.getType())) {
                    container.addEq(field.getName(), (Float)field.get(entity));
                } else if (Double.class.isAssignableFrom(field.getType())) {
                    container.addEq(field.getName(), (Double)field.get(entity));
                } else if (BigInteger.class.isAssignableFrom(field.getType())) {
                    container.addEq(field.getName(), (BigInteger)field.get(entity));
                } else if (BigDecimal.class.isAssignableFrom(field.getType())) {
                    container.addEq(field.getName(), (BigDecimal)field.get(entity));
                } else if (Character.class.isAssignableFrom(field.getType())) {
                    container.addEq(field.getName(), (Character)field.get(entity));
                }
            }
        }
        return find(entity.getClass(), container);
    }

    /**
     * Return Entities which macth the criteria set in the restriction container
     *
     * @param entityClass
     * @param container   :container of predicate
     * @param orders      : Result orders criteria
     * @param properties  : Lazy properties to load
     * @param firstResult : first result
     * @param maxResult   : max result
     * @return
     */
    @Override
    public List doSearch(Class<?> entityClass, RestrictionsContainer container, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        assert Objects.nonNull(container):"Restriction Container can't be null";
        assert Objects.nonNull(entityClass): "Entity Class can't be null";

        TypedQuery query = buildTypedQueryFrom(entityClass, container, orders, properties, firstResult, maxResult);

        return query.getResultList();
    }

    /**
     * Return Entities which macth the criteria set in the restriction container
     *
     * @param entityClass
     * @param container   :container of predicat
     * @param orders      : Result orders criteria
     * @param properties  : Lazy properties to load
     * @param hints       :
     * @param firstResult : first result
     * @param maxResult   : max result
     * @return
     */
    @Override
    public List doSearch(Class<?> entityClass, RestrictionsContainer container, Map<String, OrderType> orders, Set<String> properties, Map<String, Object> hints, int firstResult, int maxResult) {
        assert Objects.nonNull(container):"Restriction Container can't be null";
        assert Objects.nonNull(entityClass): "Entity Class can't be null";

        TypedQuery query = buildTypedQueryFrom(entityClass, container, orders, properties, firstResult, maxResult);

        if (CollectionUtils.isEmpty(hints)) {
            hints.keySet().forEach(entry  -> query.setHint(entry , hints.get(entry)));
        }
        return query.getResultList();
    }

    /**
     * Execute criteriq Query
     *
     * @param criteriaQuery : Criteria Query
     * @param parameters    : Map of parameters
     * @return
     */
    @Override
    public List doSearch(CriteriaQuery<?> criteriaQuery, Map<String, Object> parameters) {
        assert Objects.nonNull(criteriaQuery):"Criteria Query can't be null";

        TypedQuery<?> query =  em.createQuery(criteriaQuery);
        addQueryParameters(query , parameters);

        return query.getResultList();
    }

    /**
     * Execute Query base on Query
     *
     * @param queryString : Query String
     * @param parameters  : Map of parameters
     * @return
     */
    @Override
    public List doSearch(String queryString, Map<String, Object> parameters) {
        assert StringUtils.isNotBlank(queryString):"Query can't be null";

        final Query query = em.createQuery(queryString);
        addQueryParameters(query , parameters);

        return query.getResultList();
    }

    /**
     * Number of entities which match the criteria
     *
     * @param entityClass
     * @param container
     * @return
     */
    @Override
    public long count(Class<?> entityClass, RestrictionsContainer container) {
        return 0;
    }

    /**
     *
     * @param entityClass
     * @param container
     * @param orders
     * @param properties
     * @param firstResult
     * @param maxResult
     * @return
     */
    private TypedQuery buildTypedQueryFrom(Class<?> entityClass, RestrictionsContainer container, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        final List<Predicat> predicats = container.getPredicats();
        final CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        final CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(entityClass);
        final Root root = criteriaQuery.from(entityClass);

        root.alias("ROOT");
        criteriaQuery.select(root);

        if (!CollectionUtils.isEmpty(predicats)) {
            addPredicates(criteriaBuilder, root, criteriaQuery, predicats);
        }

        if (!CollectionUtils.isEmpty(orders)) {
            addOrders(criteriaBuilder, root, criteriaQuery, orders);
        }

        if (!CollectionUtils.isEmpty(properties)) {
            addProperties(root, criteriaQuery, properties);
        }

        TypedQuery query = em.createQuery(criteriaQuery);

        query.setFirstResult(0);

        if (firstResult > 0) {
            query.setFirstResult(firstResult);
        }
        if(maxResult >0){
            query.setMaxResults(maxResult);
        }
        return query;
    }

}
