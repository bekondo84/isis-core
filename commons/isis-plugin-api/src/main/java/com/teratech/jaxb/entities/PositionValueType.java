//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.06.26 à 06:03:28 PM WAT 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour positionValueType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <pre>
 * &lt;simpleType name="positionValueType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="workflow"/&gt;
 *     &lt;enumeration value="actions"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "positionValueType", namespace = "http://www.isis.cm/config/isis-positionvalue")
@XmlEnum
public enum PositionValueType {

    @XmlEnumValue("workflow")
    WORKFLOW("workflow"),
    @XmlEnumValue("actions")
    ACTIONS("actions");
    private final String value;

    PositionValueType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PositionValueType fromValue(String v) {
        for (PositionValueType c: PositionValueType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
