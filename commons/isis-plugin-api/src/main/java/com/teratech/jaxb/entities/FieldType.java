//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.06.17 à 01:13:57 PM WAT 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java pour fieldType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="fieldType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.isis.cm/config/isis-actions}actions" minOccurs="0"/&gt;
 *         &lt;element name="filters" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="filter" type="{http://www.isis.cm/config/editor-area}filterType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="qualifier" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="position" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" default="100" /&gt;
 *       &lt;attribute name="widget" type="{http://www.isis.cm/config/isis-widget}widgetType" /&gt;
 *       &lt;attribute name="editable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *       &lt;attribute name="updatable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *       &lt;attribute name="deletable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *       &lt;attribute name="search" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="observable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="observe" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
 *       &lt;attribute name="handler" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fieldType", propOrder = {
    "actions",
    "filters"
})
public class FieldType {

    @XmlElement(namespace = "http://www.isis.cm/config/isis-actions")
    protected Actions actions;
    protected Filters filters;
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
    @XmlAttribute(name = "deletable")
    protected Boolean deletable;
    @XmlAttribute(name = "search")
    protected Boolean search;
    @XmlAttribute(name = "observable")
    protected Boolean observable;
    @XmlAttribute(name = "observe")
    protected String observe;
    @XmlAttribute(name = "handler")
    protected String handler;

    /**
     * Obtient la valeur de la propriété actions.
     * 
     * @return
     *     possible object is
     *     {@link Actions }
     *     
     */
    public Actions getActions() {
        return actions;
    }

    /**
     * Définit la valeur de la propriété actions.
     * 
     * @param value
     *     allowed object is
     *     {@link Actions }
     *     
     */
    public void setActions(Actions value) {
        this.actions = value;
    }

    /**
     * Obtient la valeur de la propriété filters.
     * 
     * @return
     *     possible object is
     *     {@link Filters }
     *     
     */
    public Filters getFilters() {
        return filters;
    }

    /**
     * Définit la valeur de la propriété filters.
     * 
     * @param value
     *     allowed object is
     *     {@link Filters }
     *     
     */
    public void setFilters(Filters value) {
        this.filters = value;
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
     * Obtient la valeur de la propriété deletable.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDeletable() {
        if (deletable == null) {
            return true;
        } else {
            return deletable;
        }
    }

    /**
     * Définit la valeur de la propriété deletable.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeletable(Boolean value) {
        this.deletable = value;
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
     * Obtient la valeur de la propriété observable.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isObservable() {
        if (observable == null) {
            return false;
        } else {
            return observable;
        }
    }

    /**
     * Définit la valeur de la propriété observable.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setObservable(Boolean value) {
        this.observable = value;
    }

    /**
     * Obtient la valeur de la propriété observe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObserve() {
        if (observe == null) {
            return "";
        } else {
            return observe;
        }
    }

    /**
     * Définit la valeur de la propriété observe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObserve(String value) {
        this.observe = value;
    }

    /**
     * Obtient la valeur de la propriété handler.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHandler() {
        if (handler == null) {
            return "";
        } else {
            return handler;
        }
    }

    /**
     * Définit la valeur de la propriété handler.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHandler(String value) {
        this.handler = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="filter" type="{http://www.isis.cm/config/editor-area}filterType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "filter"
    })
    public static class Filters {

        protected List<FilterType> filter;

        /**
         * Gets the value of the filter property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the filter property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFilter().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FilterType }
         * 
         * 
         */
        public List<FilterType> getFilter() {
            if (filter == null) {
                filter = new ArrayList<FilterType>();
            }
            return this.filter;
        }

    }

}
