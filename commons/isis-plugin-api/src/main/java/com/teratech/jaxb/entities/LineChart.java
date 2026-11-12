//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.11.12 à 10:19:41 AM CET 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour LineChart complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="LineChart"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.isis.cm/config/dashboard}BarChart"&gt;
 *       &lt;attribute name="pointBgColor" type="{http://www.w3.org/2001/XMLSchema}string" default="#9333ea" /&gt;
 *       &lt;attribute name="borderColor" type="{http://www.w3.org/2001/XMLSchema}string" default="#9333ea" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineChart")
public class LineChart
    extends BarChart
{

    @XmlAttribute(name = "pointBgColor")
    protected String pointBgColor;
    @XmlAttribute(name = "borderColor")
    protected String borderColor;

    /**
     * Obtient la valeur de la propriété pointBgColor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPointBgColor() {
        if (pointBgColor == null) {
            return "#9333ea";
        } else {
            return pointBgColor;
        }
    }

    /**
     * Définit la valeur de la propriété pointBgColor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPointBgColor(String value) {
        this.pointBgColor = value;
    }

    /**
     * Obtient la valeur de la propriété borderColor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorderColor() {
        if (borderColor == null) {
            return "#9333ea";
        } else {
            return borderColor;
        }
    }

    /**
     * Définit la valeur de la propriété borderColor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorderColor(String value) {
        this.borderColor = value;
    }

}
