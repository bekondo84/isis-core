//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.10.26 à 12:04:35 PM CET 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour targetValue.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <pre>
 * &lt;simpleType name="targetValue"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="field"/&gt;
 *     &lt;enumeration value="value"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "targetValue", namespace = "http://www.isis.cm/config/isis-shutcut")
@XmlEnum
public enum TargetValue {

    @XmlEnumValue("field")
    FIELD("field"),
    @XmlEnumValue("value")
    VALUE("value");
    private final String value;

    TargetValue(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TargetValue fromValue(String v) {
        for (TargetValue c: TargetValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
