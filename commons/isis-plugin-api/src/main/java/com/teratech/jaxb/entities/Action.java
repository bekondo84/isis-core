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


/**
 * <p>Classe Java pour action complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="action"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="redirect" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
 *       &lt;attribute name="modal" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="icon" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
 *       &lt;attribute name="dynamic" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="viewMode" type="{http://www.w3.org/2001/XMLSchema}string" default="list,view" /&gt;
 *       &lt;attribute name="counter" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
 *       &lt;attribute name="typeOp" type="{http://www.isis.cm/config/isis-typeoperation}TypeOperation" default="none" /&gt;
 *       &lt;attribute name="position" type="{http://www.isis.cm/config/isis-positionvalue}positionValueType" default="actions" /&gt;
 *       &lt;attribute name="badge-color" type="{http://www.isis.cm/config/isis-color}colorType" default="bg-primary" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "action", namespace = "http://www.isis.cm/config/isis-actions")
public class Action {

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "code")
    protected String code;
    @XmlAttribute(name = "redirect")
    protected Boolean redirect;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "modal")
    protected Boolean modal;
    @XmlAttribute(name = "icon")
    protected String icon;
    @XmlAttribute(name = "dynamic")
    protected Boolean dynamic;
    @XmlAttribute(name = "viewMode")
    protected String viewMode;
    @XmlAttribute(name = "counter")
    protected String counter;
    @XmlAttribute(name = "typeOp")
    protected TypeOperation typeOp;
    @XmlAttribute(name = "position")
    protected PositionValueType position;
    @XmlAttribute(name = "badge-color")
    protected ColorType badgeColor;

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
     * Obtient la valeur de la propriété redirect.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isRedirect() {
        if (redirect == null) {
            return false;
        } else {
            return redirect;
        }
    }

    /**
     * Définit la valeur de la propriété redirect.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRedirect(Boolean value) {
        this.redirect = value;
    }

    /**
     * Obtient la valeur de la propriété type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        if (type == null) {
            return "";
        } else {
            return type;
        }
    }

    /**
     * Définit la valeur de la propriété type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
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
     * Obtient la valeur de la propriété icon.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcon() {
        if (icon == null) {
            return "";
        } else {
            return icon;
        }
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
     * Obtient la valeur de la propriété dynamic.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDynamic() {
        if (dynamic == null) {
            return false;
        } else {
            return dynamic;
        }
    }

    /**
     * Définit la valeur de la propriété dynamic.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDynamic(Boolean value) {
        this.dynamic = value;
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
     * Obtient la valeur de la propriété typeOp.
     * 
     * @return
     *     possible object is
     *     {@link TypeOperation }
     *     
     */
    public TypeOperation getTypeOp() {
        if (typeOp == null) {
            return TypeOperation.NONE;
        } else {
            return typeOp;
        }
    }

    /**
     * Définit la valeur de la propriété typeOp.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeOperation }
     *     
     */
    public void setTypeOp(TypeOperation value) {
        this.typeOp = value;
    }

    /**
     * Obtient la valeur de la propriété position.
     * 
     * @return
     *     possible object is
     *     {@link PositionValueType }
     *     
     */
    public PositionValueType getPosition() {
        if (position == null) {
            return PositionValueType.ACTIONS;
        } else {
            return position;
        }
    }

    /**
     * Définit la valeur de la propriété position.
     * 
     * @param value
     *     allowed object is
     *     {@link PositionValueType }
     *     
     */
    public void setPosition(PositionValueType value) {
        this.position = value;
    }

    /**
     * Obtient la valeur de la propriété badgeColor.
     * 
     * @return
     *     possible object is
     *     {@link ColorType }
     *     
     */
    public ColorType getBadgeColor() {
        if (badgeColor == null) {
            return ColorType.BG_PRIMARY;
        } else {
            return badgeColor;
        }
    }

    /**
     * Définit la valeur de la propriété badgeColor.
     * 
     * @param value
     *     allowed object is
     *     {@link ColorType }
     *     
     */
    public void setBadgeColor(ColorType value) {
        this.badgeColor = value;
    }

}
