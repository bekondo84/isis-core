//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.06.26 à 06:03:28 PM WAT 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java pour explorer-tree complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="explorer-tree"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="navigation-node" type="{http://www.isis.cm/config/explorer-tree}navigation-node" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="merge" type="{http://www.w3.org/2001/XMLSchema}string" default="merge" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "explorer-tree", namespace = "http://www.isis.cm/config/explorer-tree", propOrder = {
    "navigationNode"
})
@XmlRootElement(name = "explorer-tree", namespace = "http://www.isis.cm/config/explorer-tree")
public class ExplorerTree {

    @XmlElement(name = "navigation-node")
    protected List<NavigationNode> navigationNode;
    @XmlAttribute(name = "merge")
    protected String merge;

    /**
     * Gets the value of the navigationNode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the navigationNode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNavigationNode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NavigationNode }
     * 
     * 
     */
    public List<NavigationNode> getNavigationNode() {
        if (navigationNode == null) {
            navigationNode = new ArrayList<NavigationNode>();
        }
        return this.navigationNode;
    }

    /**
     * Obtient la valeur de la propriété merge.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerge() {
        if (merge == null) {
            return "merge";
        } else {
            return merge;
        }
    }

    /**
     * Définit la valeur de la propriété merge.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerge(String value) {
        this.merge = value;
    }

}
