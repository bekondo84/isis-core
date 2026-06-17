//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.06.17 à 01:13:57 PM WAT 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java pour shutcuts complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="shutcuts"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="shutcut" type="{http://www.isis.cm/config/isis-shutcut}shutcut" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shutcuts", namespace = "http://www.isis.cm/config/isis-shutcut", propOrder = {
    "shutcut"
})
public class Shutcuts {

    protected List<Shutcut> shutcut;

    /**
     * Gets the value of the shutcut property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the shutcut property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShutcut().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Shutcut }
     * 
     * 
     */
    public List<Shutcut> getShutcut() {
        if (shutcut == null) {
            shutcut = new ArrayList<Shutcut>();
        }
        return this.shutcut;
    }

}
