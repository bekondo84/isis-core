//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.10.30 à 01:41:32 PM CET 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour operatorType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <pre>
 * &lt;simpleType name="operatorType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="eq"/&gt;
 *     &lt;enumeration value="neq"/&gt;
 *     &lt;enumeration value="gt"/&gt;
 *     &lt;enumeration value="ge"/&gt;
 *     &lt;enumeration value="lt"/&gt;
 *     &lt;enumeration value="le"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "operatorType", namespace = "http://www.isis.cm/config/isis-utils")
@XmlEnum
public enum OperatorType {

    @XmlEnumValue("eq")
    EQ("eq"),
    @XmlEnumValue("neq")
    NEQ("neq"),
    @XmlEnumValue("gt")
    GT("gt"),
    @XmlEnumValue("ge")
    GE("ge"),
    @XmlEnumValue("lt")
    LT("lt"),
    @XmlEnumValue("le")
    LE("le");
    private final String value;

    OperatorType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OperatorType fromValue(String v) {
        for (OperatorType c: OperatorType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
