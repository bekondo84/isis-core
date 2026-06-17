//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.06.17 à 01:13:57 PM WAT 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java pour DashboardSubSectionType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="DashboardSubSectionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="field" type="{http://www.isis.cm/config/dashboard}DashboardItem" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="position" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" default="100" /&gt;
 *       &lt;attribute name="columns" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="header" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DashboardSubSectionType", namespace = "http://www.isis.cm/config/dashboard", propOrder = {
    "field"
})
public class DashboardSubSectionType {

    protected List<DashboardItem> field;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "position")
    @XmlSchemaType(name = "unsignedInt")
    protected Long position;
    @XmlAttribute(name = "columns")
    protected BigInteger columns;
    @XmlAttribute(name = "header")
    protected Boolean header;

    /**
     * Gets the value of the field property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the field property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getField().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DashboardItem }
     * 
     * 
     */
    public List<DashboardItem> getField() {
        if (field == null) {
            field = new ArrayList<DashboardItem>();
        }
        return this.field;
    }

    /**
     * Obtient la valeur de la propriété name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtient la valeur de la propriété position.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getPosition() {
        if (position == null) {
            return  100L;
        } else {
            return position;
        }
    }

    /**
     * Définit la valeur de la propriété position.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPosition(Long value) {
        this.position = value;
    }

    /**
     * Obtient la valeur de la propriété columns.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getColumns() {
        return columns;
    }

    /**
     * Définit la valeur de la propriété columns.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setColumns(BigInteger value) {
        this.columns = value;
    }

    /**
     * Obtient la valeur de la propriété header.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isHeader() {
        if (header == null) {
            return false;
        } else {
            return header;
        }
    }

    /**
     * Définit la valeur de la propriété header.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHeader(Boolean value) {
        this.header = value;
    }

}
