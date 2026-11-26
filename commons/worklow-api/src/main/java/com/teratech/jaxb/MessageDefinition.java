//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.11.24 à 01:48:47 PM CET 
//


package com.teratech.jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour MessageDefinition complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="MessageDefinition"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="messageRef" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="correlationKey" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageDefinition")
public class MessageDefinition {

    @XmlAttribute(name = "messageRef")
    protected String messageRef;
    @XmlAttribute(name = "correlationKey")
    protected String correlationKey;

    /**
     * Obtient la valeur de la propriété messageRef.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageRef() {
        return messageRef;
    }

    /**
     * Définit la valeur de la propriété messageRef.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageRef(String value) {
        this.messageRef = value;
    }

    /**
     * Obtient la valeur de la propriété correlationKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelationKey() {
        return correlationKey;
    }

    /**
     * Définit la valeur de la propriété correlationKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelationKey(String value) {
        this.correlationKey = value;
    }

}
