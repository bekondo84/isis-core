//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.11.24 à 01:48:47 PM CET 
//


package com.teratech.jaxb;

import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour TimerDefinition complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="TimerDefinition"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="timeDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="timeDuration" type="{http://www.w3.org/2001/XMLSchema}duration"/&gt;
 *         &lt;element name="timeCycle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimerDefinition", propOrder = {
    "timeDate",
    "timeDuration",
    "timeCycle"
})
public class TimerDefinition {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeDate;
    protected Duration timeDuration;
    protected String timeCycle;

    /**
     * Obtient la valeur de la propriété timeDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeDate() {
        return timeDate;
    }

    /**
     * Définit la valeur de la propriété timeDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeDate(XMLGregorianCalendar value) {
        this.timeDate = value;
    }

    /**
     * Obtient la valeur de la propriété timeDuration.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getTimeDuration() {
        return timeDuration;
    }

    /**
     * Définit la valeur de la propriété timeDuration.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setTimeDuration(Duration value) {
        this.timeDuration = value;
    }

    /**
     * Obtient la valeur de la propriété timeCycle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeCycle() {
        return timeCycle;
    }

    /**
     * Définit la valeur de la propriété timeCycle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeCycle(String value) {
        this.timeCycle = value;
    }

}
