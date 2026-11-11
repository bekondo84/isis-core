//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.11.11 à 02:25:21 PM CET 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

import java.math.BigInteger;


/**
 * <p>Classe Java pour ChartItem complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ChartItem"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.isis.cm/config/dashboard}AbstractDashboardItem"&gt;
 *       &lt;attribute name="action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="method" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="type" use="required" type="{http://www.isis.cm/config/dashboard}ChartType" /&gt;
 *       &lt;attribute name="refresh" type="{http://www.w3.org/2001/XMLSchema}integer" default="3600" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChartItem", namespace = "http://www.isis.cm/config/dashboard")
public class ChartItem
    extends AbstractDashboardItem
{

    @XmlAttribute(name = "action", required = true)
    protected String action;
    @XmlAttribute(name = "method", required = true)
    protected String method;
    @XmlAttribute(name = "type", required = true)
    protected ChartType type;
    @XmlAttribute(name = "refresh")
    protected BigInteger refresh;

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
     * Obtient la valeur de la propriété method.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMethod() {
        return method;
    }

    /**
     * Définit la valeur de la propriété method.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMethod(String value) {
        this.method = value;
    }

    /**
     * Obtient la valeur de la propriété type.
     * 
     * @return
     *     possible object is
     *     {@link ChartType }
     *     
     */
    public ChartType getType() {
        return type;
    }

    /**
     * Définit la valeur de la propriété type.
     * 
     * @param value
     *     allowed object is
     *     {@link ChartType }
     *     
     */
    public void setType(ChartType value) {
        this.type = value;
    }

    /**
     * Obtient la valeur de la propriété refresh.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRefresh() {
        if (refresh == null) {
            return new BigInteger("3600");
        } else {
            return refresh;
        }
    }

    /**
     * Définit la valeur de la propriété refresh.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRefresh(BigInteger value) {
        this.refresh = value;
    }

}
