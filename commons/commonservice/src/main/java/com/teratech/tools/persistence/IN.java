/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.teratech.tools.persistence;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.io.Serializable;

/**
 *
 * @author MGT
 */
public class IN<Y extends Comparable<Y>> extends Predicat implements Serializable{


    //Property name
    private String propertyName ;

    //Valeur de comparaison

    private Y[] value ;



    /**
     * Constructeur par défaut
     */
    public IN() {

    }

    public IN(String propertyName, Y ...value) {
        this.propertyName = propertyName;
        this.value = value;
        //this.value_2 = value_2;
    }
    
    

    
    /**
     * Accesseur 
     * @return 
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Modificateur
     * @param propertyName
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * Accesseur
     * @return
     */
    public Y[] getValue_1() {
        return value;
    }

     /**
     * Modificateur
     * @param value_1
     */
    public void setValue_1(Y[] value_1) {
        this.value = value_1;
    }



    @Override
    public Predicate generateJPAPredicat(CriteriaBuilder criteriaBuilder, Root<?> root) {
        CriteriaBuilder.In  inClause = criteriaBuilder.in(DAOUtilis.<String>buildPropertyPath(root, propertyName)); //new InPredicate<Y>(criteriaBuilder, DAOUtilis.<Y>buildPropertyPath(root, propertyName), value_1);

        for (Y criteria : value) {
            inClause.value(criteria);
        }

        return inClause;
    }
    
    
}
