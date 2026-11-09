//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.11.09 à 01:53:46 PM CET 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Classe Java pour AbstractDashboardSection complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="AbstractDashboardSection"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="position" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" default="100" /&gt;
 *       &lt;attribute name="columns" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" /&gt;
 *       &lt;attribute name="header" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractDashboardSection", namespace = "http://www.isis.cm/config/dashboard")
@XmlSeeAlso({
    Charts.class,
    KpiCards.class,
    WorflowKpiCards.class
})
public class AbstractDashboardSection {

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "position")
    @XmlSchemaType(name = "unsignedInt")
    protected Long position;
    @XmlAttribute(name = "columns")
    @XmlSchemaType(name = "unsignedInt")
    protected Long columns;
    @XmlAttribute(name = "header")
    protected Boolean header;

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
     *     {@link Long }
     *     
     */
    public Long getColumns() {
        return columns;
    }

    /**
     * Définit la valeur de la propriété columns.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setColumns(Long value) {
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
