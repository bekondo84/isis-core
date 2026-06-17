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
 *       &lt;sequence&gt;
 *         &lt;element name="component" type="{http://www.isis.cm/config/editor-area}editorAreaType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.isis.cm/config/isis-actions}actions" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="create" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *       &lt;attribute name="update" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *       &lt;attribute name="delete" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *       &lt;attribute name="createOnField" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *       &lt;attribute name="follower" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *       &lt;attribute name="filelink" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="searchKey" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
 *       &lt;attribute name="searchTitle" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "component",
    "actions"
})
@XmlRootElement(name = "editor-area")
public class EditorArea {

    protected EditorAreaType component;
    @XmlElement(namespace = "http://www.isis.cm/config/isis-actions")
    protected Actions actions;
    @XmlAttribute(name = "create")
    protected Boolean create;
    @XmlAttribute(name = "update")
    protected Boolean update;
    @XmlAttribute(name = "delete")
    protected Boolean delete;
    @XmlAttribute(name = "createOnField")
    protected Boolean createOnField;
    @XmlAttribute(name = "follower")
    protected Boolean follower;
    @XmlAttribute(name = "filelink")
    protected Boolean filelink;
    @XmlAttribute(name = "searchKey")
    protected String searchKey;
    @XmlAttribute(name = "searchTitle")
    protected String searchTitle;

    /**
     * Obtient la valeur de la propriété component.
     * 
     * @return
     *     possible object is
     *     {@link EditorAreaType }
     *     
     */
    public EditorAreaType getComponent() {
        return component;
    }

    /**
     * Définit la valeur de la propriété component.
     * 
     * @param value
     *     allowed object is
     *     {@link EditorAreaType }
     *     
     */
    public void setComponent(EditorAreaType value) {
        this.component = value;
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
     * Obtient la valeur de la propriété update.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isUpdate() {
        if (update == null) {
            return true;
        } else {
            return update;
        }
    }

    /**
     * Définit la valeur de la propriété update.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUpdate(Boolean value) {
        this.update = value;
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
     * Obtient la valeur de la propriété createOnField.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCreateOnField() {
        if (createOnField == null) {
            return true;
        } else {
            return createOnField;
        }
    }

    /**
     * Définit la valeur de la propriété createOnField.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCreateOnField(Boolean value) {
        this.createOnField = value;
    }

    /**
     * Obtient la valeur de la propriété follower.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isFollower() {
        if (follower == null) {
            return true;
        } else {
            return follower;
        }
    }

    /**
     * Définit la valeur de la propriété follower.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFollower(Boolean value) {
        this.follower = value;
    }

    /**
     * Obtient la valeur de la propriété filelink.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isFilelink() {
        if (filelink == null) {
            return false;
        } else {
            return filelink;
        }
    }

    /**
     * Définit la valeur de la propriété filelink.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFilelink(Boolean value) {
        this.filelink = value;
    }

    /**
     * Obtient la valeur de la propriété searchKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchKey() {
        if (searchKey == null) {
            return "";
        } else {
            return searchKey;
        }
    }

    /**
     * Définit la valeur de la propriété searchKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchKey(String value) {
        this.searchKey = value;
    }

    /**
     * Obtient la valeur de la propriété searchTitle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchTitle() {
        if (searchTitle == null) {
            return "";
        } else {
            return searchTitle;
        }
    }

    /**
     * Définit la valeur de la propriété searchTitle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchTitle(String value) {
        this.searchTitle = value;
    }

}
