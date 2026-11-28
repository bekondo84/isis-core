//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.11.28 à 01:20:18 PM CET 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour colorType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <pre>
 * &lt;simpleType name="colorType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="danger"/&gt;
 *     &lt;enumeration value="primary"/&gt;
 *     &lt;enumeration value="green"/&gt;
 *     &lt;enumeration value="success"/&gt;
 *     &lt;enumeration value="blue"/&gt;
 *     &lt;enumeration value="info"/&gt;
 *     &lt;enumeration value="orange"/&gt;
 *     &lt;enumeration value="warning"/&gt;
 *     &lt;enumeration value="red"/&gt;
 *     &lt;enumeration value="purple"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "colorType", namespace = "http://www.isis.cm/config/isis-color")
@XmlEnum
public enum ColorType {

    @XmlEnumValue("danger")
    DANGER("danger"),
    @XmlEnumValue("primary")
    PRIMARY("primary"),
    @XmlEnumValue("green")
    GREEN("green"),
    @XmlEnumValue("success")
    SUCCESS("success"),
    @XmlEnumValue("blue")
    BLUE("blue"),
    @XmlEnumValue("info")
    INFO("info"),
    @XmlEnumValue("orange")
    ORANGE("orange"),
    @XmlEnumValue("warning")
    WARNING("warning"),
    @XmlEnumValue("red")
    RED("red"),
    @XmlEnumValue("purple")
    PURPLE("purple");
    private final String value;

    ColorType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ColorType fromValue(String v) {
        for (ColorType c: ColorType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
