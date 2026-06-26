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
 * <p>Classe Java pour FilterOperator.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <pre>
 * &lt;simpleType name="FilterOperator"&gt;
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
@XmlType(name = "FilterOperator")
@XmlEnum
public enum FilterOperator {

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

    FilterOperator(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FilterOperator fromValue(String v) {
        for (FilterOperator c: FilterOperator.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
