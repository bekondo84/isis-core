//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.11.09 à 01:53:46 PM CET 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java pour KpiCards complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="KpiCards"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.isis.cm/config/dashboard}AbstractDashboardSection"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="items" type="{http://www.isis.cm/config/dashboard}CardItem" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="method" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="refresh" type="{http://www.w3.org/2001/XMLSchema}integer" default="3600" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KpiCards", namespace = "http://www.isis.cm/config/dashboard", propOrder = {
    "items"
})
public class KpiCards
    extends AbstractDashboardSection
{

    @XmlElement(required = true)
    protected List<CardItem> items;
    @XmlAttribute(name = "action", required = true)
    protected String action;
    @XmlAttribute(name = "method", required = true)
    protected String method;
    @XmlAttribute(name = "refresh")
    protected BigInteger refresh;

    /**
     * Gets the value of the items property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the items property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CardItem }
     * 
     * 
     */
    public List<CardItem> getItems() {
        if (items == null) {
            items = new ArrayList<CardItem>();
        }
        return this.items;
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
