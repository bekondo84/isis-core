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
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sequence" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="auto_install" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="summary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="contact" type="{http://www.isis.cm/config/plugin}contactType" minOccurs="0"/&gt;
 *         &lt;element name="medias" type="{http://www.isis.cm/config/plugin}mediasType" minOccurs="0"/&gt;
 *         &lt;element name="depends" type="{http://www.isis.cm/config/plugin}dependsType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "author",
    "sequence",
    "autoInstall",
    "summary",
    "description",
    "category",
    "contact",
    "medias",
    "depends"
})
@XmlRootElement(name = "plugin", namespace = "http://www.isis.cm/config/plugin")
public class Plugin {

    @XmlElement(namespace = "http://www.isis.cm/config/plugin", required = true)
    protected String name;
    @XmlElement(namespace = "http://www.isis.cm/config/plugin", required = true)
    protected String author;
    @XmlElement(namespace = "http://www.isis.cm/config/plugin")
    protected int sequence;
    @XmlElement(name = "auto_install", namespace = "http://www.isis.cm/config/plugin", defaultValue = "false")
    protected boolean autoInstall;
    @XmlElement(namespace = "http://www.isis.cm/config/plugin")
    protected String summary;
    @XmlElement(namespace = "http://www.isis.cm/config/plugin")
    protected String description;
    @XmlElement(namespace = "http://www.isis.cm/config/plugin")
    protected String category;
    @XmlElement(namespace = "http://www.isis.cm/config/plugin")
    protected ContactType contact;
    @XmlElement(namespace = "http://www.isis.cm/config/plugin")
    protected MediasType medias;
    @XmlElement(namespace = "http://www.isis.cm/config/plugin")
    protected DependsType depends;

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
     * Obtient la valeur de la propriété author.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Définit la valeur de la propriété author.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Obtient la valeur de la propriété sequence.
     * 
     */
    public int getSequence() {
        return sequence;
    }

    /**
     * Définit la valeur de la propriété sequence.
     * 
     */
    public void setSequence(int value) {
        this.sequence = value;
    }

    /**
     * Obtient la valeur de la propriété autoInstall.
     * 
     */
    public boolean isAutoInstall() {
        return autoInstall;
    }

    /**
     * Définit la valeur de la propriété autoInstall.
     * 
     */
    public void setAutoInstall(boolean value) {
        this.autoInstall = value;
    }

    /**
     * Obtient la valeur de la propriété summary.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Définit la valeur de la propriété summary.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSummary(String value) {
        this.summary = value;
    }

    /**
     * Obtient la valeur de la propriété description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la valeur de la propriété description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtient la valeur de la propriété category.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Définit la valeur de la propriété category.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Obtient la valeur de la propriété contact.
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getContact() {
        return contact;
    }

    /**
     * Définit la valeur de la propriété contact.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setContact(ContactType value) {
        this.contact = value;
    }

    /**
     * Obtient la valeur de la propriété medias.
     * 
     * @return
     *     possible object is
     *     {@link MediasType }
     *     
     */
    public MediasType getMedias() {
        return medias;
    }

    /**
     * Définit la valeur de la propriété medias.
     * 
     * @param value
     *     allowed object is
     *     {@link MediasType }
     *     
     */
    public void setMedias(MediasType value) {
        this.medias = value;
    }

    /**
     * Obtient la valeur de la propriété depends.
     * 
     * @return
     *     possible object is
     *     {@link DependsType }
     *     
     */
    public DependsType getDepends() {
        return depends;
    }

    /**
     * Définit la valeur de la propriété depends.
     * 
     * @param value
     *     allowed object is
     *     {@link DependsType }
     *     
     */
    public void setDepends(DependsType value) {
        this.depends = value;
    }

}
