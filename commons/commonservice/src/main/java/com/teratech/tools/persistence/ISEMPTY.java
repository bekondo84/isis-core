/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.teratech.tools.persistence;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.io.Serializable;

/**
 *
 * @author MGT
 */
public class ISEMPTY<Y extends Comparable<Y>> extends Predicat implements Serializable{
    
    
    //Property name
    private String propertyName ;
    
        
    /**
     * Constructeur par défaut
     */
    public ISEMPTY() {
        
    }

    public ISEMPTY(String propertyName) {
        this.propertyName = propertyName;        
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
  
  
    @Override
    public Predicate generateJPAPredicat(CriteriaBuilder criteriaBuilder, Root<?> root) {
    	return criteriaBuilder.isEmpty((Expression) DAOUtilis.<Y>buildPropertyPath(root, propertyName));
    }
    
    
}
