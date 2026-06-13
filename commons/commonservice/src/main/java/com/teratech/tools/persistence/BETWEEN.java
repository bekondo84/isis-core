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
public class BETWEEN<Y extends Comparable<Y>> extends Predicat implements Serializable{
    
    
    //Property name
    private String propertyName ;
    
    //Valeur de comparaison
    
    private Y value_1 ;
    
    //Valeur de comparaison
    
    private Y value_2 ;
    
    /**
     * Constructeur par défaut
     */
    public BETWEEN() {
        
    }

    public BETWEEN(String propertyName, Y value_1,Y value_2) {
        this.propertyName = propertyName;
        this.value_1 = value_1;
        this.value_2 = value_2;
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
    public Y getValue_1() {
        return value_1;
    }

     /**
     * Modificateur
     * @param value_1
     */
    public void setValue_1(Y value_1) {
        this.value_1 = value_1;
    }

    /**
     * Accesseur 
     * @return 
     */
    public Y getValue_2() {
        return value_2;
    }

     /**
     * Modificateur
     * @param value_2
     */
    public void setValue_2(Y value_2) {
        this.value_2 = value_2;
    }  
    

    @Override
    public Predicate generateJPAPredicat(CriteriaBuilder criteriaBuilder, Root<?> root) {
        return (Predicate) criteriaBuilder.between(DAOUtilis.<Y>buildPropertyPath(root, propertyName), value_1,value_2);
    }
    
    
}
