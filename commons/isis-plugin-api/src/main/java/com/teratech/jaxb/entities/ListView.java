//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.06.17 à 01:13:57 PM WAT 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="list" type="{http://www.isis.cm/config/list-view}listViewType" minOccurs="0"/&gt;
 *         &lt;element name="kanban" type="{http://www.isis.cm/config/list-view}templateType" minOccurs="0"/&gt;
 *         &lt;element name="calendar" type="{http://www.isis.cm/config/list-view}templateType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.isis.cm/config/isis-actions}actions" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.isis.cm/config/isis-search}search" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "list-view", namespace = "http://www.isis.cm/config/list-view")
public class ListView {

    @XmlElement(namespace = "http://www.isis.cm/config/list-view")
    protected ListViewType list;
    @XmlElement(namespace = "http://www.isis.cm/config/list-view")
    protected TemplateType kanban;
    @XmlElement(namespace = "http://www.isis.cm/config/list-view")
    protected TemplateType calendar;
    @XmlElement(namespace = "http://www.isis.cm/config/isis-actions")
    protected Actions actions;
    @XmlElement(namespace = "http://www.isis.cm/config/isis-search")
    protected Search search;

    /**
     * Obtient la valeur de la propriété list.
     * 
     * @return
     *     possible object is
     *     {@link ListViewType }
     *     
     */
    public ListViewType getList() {
        return list;
    }

    /**
     * Définit la valeur de la propriété list.
     * 
     * @param value
     *     allowed object is
     *     {@link ListViewType }
     *     
     */
    public void setList(ListViewType value) {
        this.list = value;
    }

    /**
     * Obtient la valeur de la propriété kanban.
     * 
     * @return
     *     possible object is
     *     {@link TemplateType }
     *     
     */
    public TemplateType getKanban() {
        return kanban;
    }

    /**
     * Définit la valeur de la propriété kanban.
     * 
     * @param value
     *     allowed object is
     *     {@link TemplateType }
     *     
     */
    public void setKanban(TemplateType value) {
        this.kanban = value;
    }

    /**
     * Obtient la valeur de la propriété calendar.
     * 
     * @return
     *     possible object is
     *     {@link TemplateType }
     *     
     */
    public TemplateType getCalendar() {
        return calendar;
    }

    /**
     * Définit la valeur de la propriété calendar.
     * 
     * @param value
     *     allowed object is
     *     {@link TemplateType }
     *     
     */
    public void setCalendar(TemplateType value) {
        this.calendar = value;
    }

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
     * Obtient la valeur de la propriété search.
     * 
     * @return
     *     possible object is
     *     {@link Search }
     *     
     */
    public Search getSearch() {
        return search;
    }

    /**
     * Définit la valeur de la propriété search.
     * 
     * @param value
     *     allowed object is
     *     {@link Search }
     *     
     */
    public void setSearch(Search value) {
        this.search = value;
    }

}
