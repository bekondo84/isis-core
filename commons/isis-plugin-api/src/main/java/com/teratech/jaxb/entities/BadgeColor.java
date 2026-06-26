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
 * <p>Classe Java pour BadgeColor.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <pre>
 * &lt;simpleType name="BadgeColor"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="bg-primary"/&gt;
 *     &lt;enumeration value="bg-secondary"/&gt;
 *     &lt;enumeration value="bg-success"/&gt;
 *     &lt;enumeration value="bg-danger"/&gt;
 *     &lt;enumeration value="bg-warning"/&gt;
 *     &lt;enumeration value="bg-info"/&gt;
 *     &lt;enumeration value="bg-light"/&gt;
 *     &lt;enumeration value="bg-dark"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "BadgeColor", namespace = "http://www.isis.cm/config/explorer-tree")
@XmlEnum
public enum BadgeColor {

    @XmlEnumValue("bg-primary")
    BG_PRIMARY("bg-primary"),
    @XmlEnumValue("bg-secondary")
    BG_SECONDARY("bg-secondary"),
    @XmlEnumValue("bg-success")
    BG_SUCCESS("bg-success"),
    @XmlEnumValue("bg-danger")
    BG_DANGER("bg-danger"),
    @XmlEnumValue("bg-warning")
    BG_WARNING("bg-warning"),
    @XmlEnumValue("bg-info")
    BG_INFO("bg-info"),
    @XmlEnumValue("bg-light")
    BG_LIGHT("bg-light"),
    @XmlEnumValue("bg-dark")
    BG_DARK("bg-dark");
    private final String value;

    BadgeColor(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BadgeColor fromValue(String v) {
        for (BadgeColor c: BadgeColor.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
