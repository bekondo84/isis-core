//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.06.26 à 06:03:28 PM WAT 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java pour editorAreaType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="editorAreaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="common" type="{http://www.isis.cm/config/editor-area}commonType" minOccurs="0"/&gt;
 *         &lt;element name="tab" type="{http://www.isis.cm/config/editor-area}tabType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editorAreaType", propOrder = {
    "common",
    "tab"
})
public class EditorAreaType {

    protected CommonType common;
    protected List<TabType> tab;

    /**
     * Obtient la valeur de la propriété common.
     * 
     * @return
     *     possible object is
     *     {@link CommonType }
     *     
     */
    public CommonType getCommon() {
        return common;
    }

    /**
     * Définit la valeur de la propriété common.
     * 
     * @param value
     *     allowed object is
     *     {@link CommonType }
     *     
     */
    public void setCommon(CommonType value) {
        this.common = value;
    }

    /**
     * Gets the value of the tab property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the tab property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTab().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TabType }
     * 
     * 
     */
    public List<TabType> getTab() {
        if (tab == null) {
            tab = new ArrayList<TabType>();
        }
        return this.tab;
    }

}
