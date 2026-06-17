//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.06.17 à 01:13:57 PM WAT 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour operator.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <pre>
 * &lt;simpleType name="operator"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="startWith"/&gt;
 *     &lt;enumeration value="endWith"/&gt;
 *     &lt;enumeration value="content"/&gt;
 *     &lt;enumeration value="isNull"/&gt;
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
@XmlType(name = "operator", namespace = "http://www.isis.cm/config/isis-search")
@XmlEnum
public enum Operator {

    @XmlEnumValue("startWith")
    START_WITH("startWith"),
    @XmlEnumValue("endWith")
    END_WITH("endWith"),
    @XmlEnumValue("content")
    CONTENT("content"),
    @XmlEnumValue("isNull")
    IS_NULL("isNull"),
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

    Operator(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Operator fromValue(String v) {
        for (Operator c: Operator.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
