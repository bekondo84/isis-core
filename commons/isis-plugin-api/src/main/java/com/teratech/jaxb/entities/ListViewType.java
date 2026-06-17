//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.06.17 à 01:13:57 PM WAT 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java pour listViewType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="listViewType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="column" type="{http://www.isis.cm/config/list-view}columnType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="template" type="{http://www.isis.cm/config/list-view}templateType" minOccurs="0"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="create" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *       &lt;attribute name="delete" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *       &lt;attribute name="viewable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listViewType", namespace = "http://www.isis.cm/config/list-view", propOrder = {
    "column",
    "template"
})
public class ListViewType {

    protected List<ColumnType> column;
    protected TemplateType template;
    @XmlAttribute(name = "create")
    protected Boolean create;
    @XmlAttribute(name = "delete")
    protected Boolean delete;
    @XmlAttribute(name = "viewable")
    protected Boolean viewable;

    /**
     * Gets the value of the column property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the column property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColumn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColumnType }
     * 
     * 
     */
    public List<ColumnType> getColumn() {
        if (column == null) {
            column = new ArrayList<ColumnType>();
        }
        return this.column;
    }

    /**
     * Obtient la valeur de la propriété template.
     * 
     * @return
     *     possible object is
     *     {@link TemplateType }
     *     
     */
    public TemplateType getTemplate() {
        return template;
    }

    /**
     * Définit la valeur de la propriété template.
     * 
     * @param value
     *     allowed object is
     *     {@link TemplateType }
     *     
     */
    public void setTemplate(TemplateType value) {
        this.template = value;
    }

    /**
     * Obtient la valeur de la propriété create.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCreate() {
        if (create == null) {
            return true;
        } else {
            return create;
        }
    }

    /**
     * Définit la valeur de la propriété create.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCreate(Boolean value) {
        this.create = value;
    }

    /**
     * Obtient la valeur de la propriété delete.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDelete() {
        if (delete == null) {
            return true;
        } else {
            return delete;
        }
    }

    /**
     * Définit la valeur de la propriété delete.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDelete(Boolean value) {
        this.delete = value;
    }

    /**
     * Obtient la valeur de la propriété viewable.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isViewable() {
        if (viewable == null) {
            return true;
        } else {
            return viewable;
        }
    }

    /**
     * Définit la valeur de la propriété viewable.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setViewable(Boolean value) {
        this.viewable = value;
    }

}
