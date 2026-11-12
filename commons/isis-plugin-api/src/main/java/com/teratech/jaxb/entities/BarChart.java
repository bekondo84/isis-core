//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.11.12 à 10:19:41 AM CET 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Classe Java pour BarChart complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="BarChart"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.isis.cm/config/dashboard}ChartItem"&gt;
 *       &lt;attribute name="bgColor" type="{http://www.w3.org/2001/XMLSchema}string" default="#9333ea" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BarChart")
@XmlSeeAlso({
    LineChart.class
})
public class BarChart
    extends ChartItem
{

    @XmlAttribute(name = "bgColor")
    protected String bgColor;

    /**
     * Obtient la valeur de la propriété bgColor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBgColor() {
        if (bgColor == null) {
            return "#9333ea";
        } else {
            return bgColor;
        }
    }

    /**
     * Définit la valeur de la propriété bgColor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBgColor(String value) {
        this.bgColor = value;
    }

}
