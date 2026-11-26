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
 * <p>Classe Java pour SignalDefinition complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="SignalDefinition"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="signalRef" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignalDefinition")
public class SignalDefinition {

    @XmlAttribute(name = "signalRef", required = true)
    protected String signalRef;

    /**
     * Obtient la valeur de la propriété signalRef.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignalRef() {
        return signalRef;
    }

    /**
     * Définit la valeur de la propriété signalRef.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignalRef(String value) {
        this.signalRef = value;
    }

}
