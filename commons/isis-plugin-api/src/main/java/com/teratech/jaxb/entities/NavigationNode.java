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
 * <p>Classe Java pour navigation-node complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="navigation-node"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="navigation-node" type="{http://www.isis.cm/config/explorer-tree}navigation-node" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="action" type="{http://www.w3.org/2001/XMLSchema}string" default="defaultAction" /&gt;
 *       &lt;attribute name="modal" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="viewMode" type="{http://www.w3.org/2001/XMLSchema}string" default="list,view" /&gt;
 *       &lt;attribute name="icon" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="position" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" default="0" /&gt;
 *       &lt;attribute name="template" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="counter" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
 *       &lt;attribute name="badge-color" type="{http://www.isis.cm/config/explorer-tree}BadgeColor" default="bg-primary" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "navigation-node", namespace = "http://www.isis.cm/config/explorer-tree", propOrder = {
    "navigationNode"
})
public class NavigationNode {

    @XmlElement(name = "navigation-node")
    protected List<NavigationNode> navigationNode;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "code")
    protected String code;
    @XmlAttribute(name = "action")
    protected String action;
    @XmlAttribute(name = "modal")
    protected Boolean modal;
    @XmlAttribute(name = "viewMode")
    protected String viewMode;
    @XmlAttribute(name = "icon")
    protected String icon;
    @XmlAttribute(name = "position")
    @XmlSchemaType(name = "unsignedByte")
    protected Short position;
    @XmlAttribute(name = "template")
    protected String template;
    @XmlAttribute(name = "counter")
    protected String counter;
    @XmlAttribute(name = "badge-color")
    protected BadgeColor badgeColor;

    /**
     * Gets the value of the navigationNode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the navigationNode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNavigationNode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NavigationNode }
     * 
     * 
     */
    public List<NavigationNode> getNavigationNode() {
        if (navigationNode == null) {
            navigationNode = new ArrayList<NavigationNode>();
        }
        return this.navigationNode;
    }

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Définit la valeur de la propriété code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Obtient la valeur de la propriété action.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        if (action == null) {
            return "defaultAction";
        } else {
            return action;
        }
    }

    /**
     * Définit la valeur de la propriété action.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

    /**
     * Obtient la valeur de la propriété modal.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isModal() {
        if (modal == null) {
            return false;
        } else {
            return modal;
        }
    }

    /**
     * Définit la valeur de la propriété modal.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setModal(Boolean value) {
        this.modal = value;
    }

    /**
     * Obtient la valeur de la propriété viewMode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getViewMode() {
        if (viewMode == null) {
            return "list,view";
        } else {
            return viewMode;
        }
    }

    /**
     * Définit la valeur de la propriété viewMode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setViewMode(String value) {
        this.viewMode = value;
    }

    /**
     * Obtient la valeur de la propriété icon.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Définit la valeur de la propriété icon.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIcon(String value) {
        this.icon = value;
    }

    /**
     * Obtient la valeur de la propriété position.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public short getPosition() {
        if (position == null) {
            return ((short) 0);
        } else {
            return position;
        }
    }

    /**
     * Définit la valeur de la propriété position.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setPosition(Short value) {
        this.position = value;
    }

    /**
     * Obtient la valeur de la propriété template.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplate() {
        return template;
    }

    /**
     * Définit la valeur de la propriété template.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplate(String value) {
        this.template = value;
    }

    /**
     * Obtient la valeur de la propriété counter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCounter() {
        if (counter == null) {
            return "";
        } else {
            return counter;
        }
    }

    /**
     * Définit la valeur de la propriété counter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCounter(String value) {
        this.counter = value;
    }

    /**
     * Obtient la valeur de la propriété badgeColor.
     * 
     * @return
     *     possible object is
     *     {@link BadgeColor }
     *     
     */
    public BadgeColor getBadgeColor() {
        if (badgeColor == null) {
            return BadgeColor.BG_PRIMARY;
        } else {
            return badgeColor;
        }
    }

    /**
     * Définit la valeur de la propriété badgeColor.
     * 
     * @param value
     *     allowed object is
     *     {@link BadgeColor }
     *     
     */
    public void setBadgeColor(BadgeColor value) {
        this.badgeColor = value;
    }

}
