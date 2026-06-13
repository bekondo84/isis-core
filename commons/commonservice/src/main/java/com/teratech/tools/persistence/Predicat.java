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
 * Un predicat represent une condition dans une requete 
 * @author Bekondo Kangue Dieunedort <bekondo_dieu@yahoo.fr>
 */
public abstract class Predicat implements Serializable{
    
   
    /**
     * Constructeur par défaut
     */
    public  Predicat() {
        
    }

  
   
    /**
	 * Methode de construction d'un Predicat JPA 2
	 * @param criteriaBuilder	Constructeur de critere
	 * @param root	Racine de la requete par critere
	 * @return	Predicat JPA 2
	 */
    public abstract Predicate generateJPAPredicat(CriteriaBuilder criteriaBuilder , Root<?> root );
       
    
}
