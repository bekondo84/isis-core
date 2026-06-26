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
 * <p>Classe Java pour TypeOperation.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <pre>
 * &lt;simpleType name="TypeOperation"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="create"/&gt;
 *     &lt;enumeration value="edit"/&gt;
 *     &lt;enumeration value="delete"/&gt;
 *     &lt;enumeration value="print"/&gt;
 *     &lt;enumeration value="import"/&gt;
 *     &lt;enumeration value="none"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TypeOperation", namespace = "http://www.isis.cm/config/isis-typeoperation")
@XmlEnum
public enum TypeOperation {

    @XmlEnumValue("create")
    CREATE("create"),
    @XmlEnumValue("edit")
    EDIT("edit"),
    @XmlEnumValue("delete")
    DELETE("delete"),
    @XmlEnumValue("print")
    PRINT("print"),
    @XmlEnumValue("import")
    IMPORT("import"),
    @XmlEnumValue("none")
    NONE("none");
    private final String value;

    TypeOperation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TypeOperation fromValue(String v) {
        for (TypeOperation c: TypeOperation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
