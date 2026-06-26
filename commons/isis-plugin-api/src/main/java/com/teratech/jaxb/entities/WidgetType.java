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
 * <p>Classe Java pour widgetType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <pre>
 * &lt;simpleType name="widgetType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="media"/&gt;
 *     &lt;enumeration value="image"/&gt;
 *     &lt;enumeration value="file"/&gt;
 *     &lt;enumeration value="text"/&gt;
 *     &lt;enumeration value="time"/&gt;
 *     &lt;enumeration value="number"/&gt;
 *     &lt;enumeration value="date"/&gt;
 *     &lt;enumeration value="password"/&gt;
 *     &lt;enumeration value="datetime-local"/&gt;
 *     &lt;enumeration value="select"/&gt;
 *     &lt;enumeration value="combobox"/&gt;
 *     &lt;enumeration value="checkbox"/&gt;
 *     &lt;enumeration value="switch"/&gt;
 *     &lt;enumeration value="textarea"/&gt;
 *     &lt;enumeration value="onetomany"/&gt;
 *     &lt;enumeration value="manytoone"/&gt;
 *     &lt;enumeration value="manytomany"/&gt;
 *     &lt;enumeration value="manytomanylist"/&gt;
 *     &lt;enumeration value="localized"/&gt;
 *     &lt;enumeration value="localized-editor"/&gt;
 *     &lt;enumeration value="localized-area"/&gt;
 *     &lt;enumeration value="editor"/&gt;
 *     &lt;enumeration value="texteditor"/&gt;
 *     &lt;enumeration value="card"/&gt;
 *     &lt;enumeration value="pie"/&gt;
 *     &lt;enumeration value="doughnut"/&gt;
 *     &lt;enumeration value="line"/&gt;
 *     &lt;enumeration value="bar"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "widgetType", namespace = "http://www.isis.cm/config/isis-widget")
@XmlEnum
public enum WidgetType {

    @XmlEnumValue("media")
    MEDIA("media"),
    @XmlEnumValue("image")
    IMAGE("image"),
    @XmlEnumValue("file")
    FILE("file"),
    @XmlEnumValue("text")
    TEXT("text"),
    @XmlEnumValue("time")
    TIME("time"),
    @XmlEnumValue("number")
    NUMBER("number"),
    @XmlEnumValue("date")
    DATE("date"),
    @XmlEnumValue("password")
    PASSWORD("password"),
    @XmlEnumValue("datetime-local")
    DATETIME_LOCAL("datetime-local"),
    @XmlEnumValue("select")
    SELECT("select"),
    @XmlEnumValue("combobox")
    COMBOBOX("combobox"),
    @XmlEnumValue("checkbox")
    CHECKBOX("checkbox"),
    @XmlEnumValue("switch")
    SWITCH("switch"),
    @XmlEnumValue("textarea")
    TEXTAREA("textarea"),
    @XmlEnumValue("onetomany")
    ONETOMANY("onetomany"),
    @XmlEnumValue("manytoone")
    MANYTOONE("manytoone"),
    @XmlEnumValue("manytomany")
    MANYTOMANY("manytomany"),
    @XmlEnumValue("manytomanylist")
    MANYTOMANYLIST("manytomanylist"),
    @XmlEnumValue("localized")
    LOCALIZED("localized"),
    @XmlEnumValue("localized-editor")
    LOCALIZED_EDITOR("localized-editor"),
    @XmlEnumValue("localized-area")
    LOCALIZED_AREA("localized-area"),
    @XmlEnumValue("editor")
    EDITOR("editor"),
    @XmlEnumValue("texteditor")
    TEXTEDITOR("texteditor"),
    @XmlEnumValue("card")
    CARD("card"),
    @XmlEnumValue("pie")
    PIE("pie"),
    @XmlEnumValue("doughnut")
    DOUGHNUT("doughnut"),
    @XmlEnumValue("line")
    LINE("line"),
    @XmlEnumValue("bar")
    BAR("bar");
    private final String value;

    WidgetType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WidgetType fromValue(String v) {
        for (WidgetType c: WidgetType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
