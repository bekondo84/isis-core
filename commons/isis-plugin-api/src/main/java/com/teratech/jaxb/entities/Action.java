//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.10.23 à 09:28:43 AM CEST 
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
 *       &lt;attribute name="code" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="type" use="required" type="{http://www.isis.cm/config/isis-actions}actionType" /&gt;
 *       &lt;attribute name="icon" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
 *       &lt;attribute name="askconfirmation" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="operation" type="{http://www.isis.cm/config/isis-typeoperation}TypeOperation" default="none" /&gt;
 *       &lt;attribute name="position" type="{http://www.isis.cm/config/isis-positionvalue}positionValueType" default="actions" /&gt;
 *       &lt;attribute name="color" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
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

    @XmlAttribute(name = "code", required = true)
    protected String code;
    @XmlAttribute(name = "action", required = true)
    protected String action;
    @XmlAttribute(name = "type", required = true)
    protected ActionType type;
    @XmlAttribute(name = "icon")
    protected String icon;
    @XmlAttribute(name = "askconfirmation")
    protected Boolean askconfirmation;
    @XmlAttribute(name = "operation")
    protected TypeOperation operation;
    @XmlAttribute(name = "position")
    protected PositionValueType position;
    @XmlAttribute(name = "color")
    protected String color;

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
        return action;
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
     * Obtient la valeur de la propriété type.
     * 
     * @return
     *     possible object is
     *     {@link ActionType }
     *     
     */
    public ActionType getType() {
        return type;
    }

    /**
     * Définit la valeur de la propriété type.
     * 
     * @param value
     *     allowed object is
     *     {@link ActionType }
     *     
     */
    public void setType(ActionType value) {
        this.type = value;
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
     * Obtient la valeur de la propriété askconfirmation.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isAskconfirmation() {
        if (askconfirmation == null) {
            return false;
        } else {
            return askconfirmation;
        }
    }

    /**
     * Définit la valeur de la propriété askconfirmation.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAskconfirmation(Boolean value) {
        this.askconfirmation = value;
    }

    /**
     * Obtient la valeur de la propriété operation.
     * 
     * @return
     *     possible object is
     *     {@link TypeOperation }
     *     
     */
    public TypeOperation getOperation() {
        if (operation == null) {
            return TypeOperation.NONE;
        } else {
            return operation;
        }
    }

    /**
     * Définit la valeur de la propriété operation.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeOperation }
     *     
     */
    public void setOperation(TypeOperation value) {
        this.operation = value;
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
     * Obtient la valeur de la propriété color.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        if (color == null) {
            return "";
        } else {
            return color;
        }
    }

    /**
     * Définit la valeur de la propriété color.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(String value) {
        this.color = value;
    }

}
