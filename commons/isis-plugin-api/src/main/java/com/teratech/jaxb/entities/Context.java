//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.06.17 à 01:13:57 PM WAT 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;sequence&gt;
 *           &lt;element ref="{http://www.isis.cm/config/list-view}list-view" minOccurs="0"/&gt;
 *           &lt;element ref="{http://www.isis.cm/config/editor-area}editor-area" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;sequence&gt;
 *           &lt;element ref="{http://www.isis.cm/config/dashboard}dashbord"/&gt;
 *         &lt;/sequence&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="action" type="{http://www.w3.org/2001/XMLSchema}string" default="defaultAction" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "listView",
    "editorArea",
    "dashbord"
})
@XmlRootElement(name = "context", namespace = "http://www.isis.cm/config/isis-template")
public class Context {

    @XmlElement(name = "list-view", namespace = "http://www.isis.cm/config/list-view")
    protected ListView listView;
    @XmlElement(name = "editor-area")
    protected EditorArea editorArea;
    @XmlElement(namespace = "http://www.isis.cm/config/dashboard")
    protected Dashbord dashbord;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "action")
    protected String action;

    /**
     * Obtient la valeur de la propriété listView.
     * 
     * @return
     *     possible object is
     *     {@link ListView }
     *     
     */
    public ListView getListView() {
        return listView;
    }

    /**
     * Définit la valeur de la propriété listView.
     * 
     * @param value
     *     allowed object is
     *     {@link ListView }
     *     
     */
    public void setListView(ListView value) {
        this.listView = value;
    }

    /**
     * Obtient la valeur de la propriété editorArea.
     * 
     * @return
     *     possible object is
     *     {@link EditorArea }
     *     
     */
    public EditorArea getEditorArea() {
        return editorArea;
    }

    /**
     * Définit la valeur de la propriété editorArea.
     * 
     * @param value
     *     allowed object is
     *     {@link EditorArea }
     *     
     */
    public void setEditorArea(EditorArea value) {
        this.editorArea = value;
    }

    /**
     * Obtient la valeur de la propriété dashbord.
     * 
     * @return
     *     possible object is
     *     {@link Dashbord }
     *     
     */
    public Dashbord getDashbord() {
        return dashbord;
    }

    /**
     * Définit la valeur de la propriété dashbord.
     * 
     * @param value
     *     allowed object is
     *     {@link Dashbord }
     *     
     */
    public void setDashbord(Dashbord value) {
        this.dashbord = value;
    }

    /**
     * Obtient la valeur de la propriété name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtient la valeur de la propriété action.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        if (action == null) {
            return "defaultAction";
        } else {
            return action;
        }
    }

    /**
     * Définit la valeur de la propriété action.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

}
