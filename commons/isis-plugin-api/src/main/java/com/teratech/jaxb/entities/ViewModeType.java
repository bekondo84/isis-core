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
 * <p>Classe Java pour viewModeType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <pre>
 * &lt;simpleType name="viewModeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="list"/&gt;
 *     &lt;enumeration value="dashboard"/&gt;
 *     &lt;enumeration value="view"/&gt;
 *     &lt;enumeration value="kaban"/&gt;
 *     &lt;enumeration value="list,view"/&gt;
 *     &lt;enumeration value="kaban,view"/&gt;
 *     &lt;enumeration value="list,kaban,view"/&gt;
 *     &lt;enumeration value="kaban,list,view"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "viewModeType", namespace = "http://www.isis.cm/config/isis-utils")
@XmlEnum
public enum ViewModeType {

    @XmlEnumValue("list")
    LIST("list"),
    @XmlEnumValue("dashboard")
    DASHBOARD("dashboard"),
    @XmlEnumValue("view")
    VIEW("view"),
    @XmlEnumValue("kaban")
    KABAN("kaban"),
    @XmlEnumValue("list,view")
    LIST_VIEW("list,view"),
    @XmlEnumValue("kaban,view")
    KABAN_VIEW("kaban,view"),
    @XmlEnumValue("list,kaban,view")
    LIST_KABAN_VIEW("list,kaban,view"),
    @XmlEnumValue("kaban,list,view")
    KABAN_LIST_VIEW("kaban,list,view");
    private final String value;

    ViewModeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ViewModeType fromValue(String v) {
        for (ViewModeType c: ViewModeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
