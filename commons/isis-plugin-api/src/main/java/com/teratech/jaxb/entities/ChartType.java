//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.11.09 à 01:53:46 PM CET 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ChartType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <pre>
 * &lt;simpleType name="ChartType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="pie"/&gt;
 *     &lt;enumeration value="line"/&gt;
 *     &lt;enumeration value="doughnut"/&gt;
 *     &lt;enumeration value="bar"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ChartType", namespace = "http://www.isis.cm/config/dashboard")
@XmlEnum
public enum ChartType {

    @XmlEnumValue("pie")
    PIE("pie"),
    @XmlEnumValue("line")
    LINE("line"),
    @XmlEnumValue("doughnut")
    DOUGHNUT("doughnut"),
    @XmlEnumValue("bar")
    BAR("bar");
    private final String value;

    ChartType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ChartType fromValue(String v) {
        for (ChartType c: ChartType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
