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
public class NOTLIKE<Y extends Comparable<Y>> extends Predicat implements Serializable{
    
    
    //Property name
    private String propertyName ;
    
    //Valeur de comparaison
    
    private String value ;
    
    
    /**
     * Constructeur par défaut
     */
    public NOTLIKE() {
        
    }

    public NOTLIKE(String propertyName, String value) {
        this.propertyName = propertyName;
        this.value = value;
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
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

  
    /**
     * Accesseur 
     * @return 
     */
    public String getValue() {
        return value;
    }

    /**
     * Modificateur
     */
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public Predicate generateJPAPredicat(CriteriaBuilder criteriaBuilder, Root<?> root) {
        return criteriaBuilder.notLike(DAOUtilis.<String>buildPropertyPath(root, propertyName), value);
    }
    
    
}
