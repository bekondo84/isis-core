//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.06.17 à 01:13:57 PM WAT 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Classe Java pour columnType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="columnType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="pattern" type="{http://www.isis.cm/config/list-view}pattern" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="qualifier" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="position" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" default="100" /&gt;
 *       &lt;attribute name="widget" type="{http://www.isis.cm/config/isis-widget}widgetType" /&gt;
 *       &lt;attribute name="editable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *       &lt;attribute name="updatable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *       &lt;attribute name="search" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="show" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "columnType", namespace = "http://www.isis.cm/config/list-view", propOrder = {
    "pattern"
})
public class ColumnType {

    protected Pattern pattern;
    @XmlAttribute(name = "qualifier")
    protected String qualifier;
    @XmlAttribute(name = "position")
    @XmlSchemaType(name = "unsignedInt")
    protected Long position;
    @XmlAttribute(name = "widget")
    protected WidgetType widget;
    @XmlAttribute(name = "editable")
    protected Boolean editable;
    @XmlAttribute(name = "updatable")
    protected Boolean updatable;
    @XmlAttribute(name = "search")
    protected Boolean search;
    @XmlAttribute(name = "show")
    protected Boolean show;

    /**
     * Obtient la valeur de la propriété pattern.
     * 
     * @return
     *     possible object is
     *     {@link Pattern }
     *     
     */
    public Pattern getPattern() {
        return pattern;
    }

    /**
     * Définit la valeur de la propriété pattern.
     * 
     * @param value
     *     allowed object is
     *     {@link Pattern }
     *     
     */
    public void setPattern(Pattern value) {
        this.pattern = value;
    }

    /**
     * Obtient la valeur de la propriété qualifier.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQualifier() {
        return qualifier;
    }

    /**
     * Définit la valeur de la propriété qualifier.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQualifier(String value) {
        this.qualifier = value;
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
     * Obtient la valeur de la propriété widget.
     * 
     * @return
     *     possible object is
     *     {@link WidgetType }
     *     
     */
    public WidgetType getWidget() {
        return widget;
    }

    /**
     * Définit la valeur de la propriété widget.
     * 
     * @param value
     *     allowed object is
     *     {@link WidgetType }
     *     
     */
    public void setWidget(WidgetType value) {
        this.widget = value;
    }

    /**
     * Obtient la valeur de la propriété editable.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isEditable() {
        if (editable == null) {
            return true;
        } else {
            return editable;
        }
    }

    /**
     * Définit la valeur de la propriété editable.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEditable(Boolean value) {
        this.editable = value;
    }

    /**
     * Obtient la valeur de la propriété updatable.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isUpdatable() {
        if (updatable == null) {
            return true;
        } else {
            return updatable;
        }
    }

    /**
     * Définit la valeur de la propriété updatable.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUpdatable(Boolean value) {
        this.updatable = value;
    }

    /**
     * Obtient la valeur de la propriété search.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isSearch() {
        if (search == null) {
            return false;
        } else {
            return search;
        }
    }

    /**
     * Définit la valeur de la propriété search.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSearch(Boolean value) {
        this.search = value;
    }

    /**
     * Obtient la valeur de la propriété show.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isShow() {
        if (show == null) {
            return true;
        } else {
            return show;
        }
    }

    /**
     * Définit la valeur de la propriété show.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShow(Boolean value) {
        this.show = value;
    }

}
