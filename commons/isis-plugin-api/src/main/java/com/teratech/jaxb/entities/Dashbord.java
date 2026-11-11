//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.11.11 à 02:25:21 PM CET 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element name="charts" type="{http://www.isis.cm/config/dashboard}Charts"/&gt;
 *         &lt;element name="kpiCards" type="{http://www.isis.cm/config/dashboard}KpiCards"/&gt;
 *         &lt;element name="workflowKpiCards" type="{http://www.isis.cm/config/dashboard}WorflowKpiCards"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "chartsOrKpiCardsOrWorkflowKpiCards"
})
@XmlRootElement(name = "dashbord", namespace = "http://www.isis.cm/config/dashboard")
public class Dashbord {

    @XmlElements({
        @XmlElement(name = "charts", namespace = "http://www.isis.cm/config/dashboard", type = Charts.class),
        @XmlElement(name = "kpiCards", namespace = "http://www.isis.cm/config/dashboard", type = KpiCards.class),
        @XmlElement(name = "workflowKpiCards", namespace = "http://www.isis.cm/config/dashboard", type = WorflowKpiCards.class)
    })
    protected List<AbstractDashboardSection> chartsOrKpiCardsOrWorkflowKpiCards;
    @XmlAttribute(name = "action", required = true)
    protected String action;

    /**
     * Gets the value of the chartsOrKpiCardsOrWorkflowKpiCards property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the chartsOrKpiCardsOrWorkflowKpiCards property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChartsOrKpiCardsOrWorkflowKpiCards().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Charts }
     * {@link KpiCards }
     * {@link WorflowKpiCards }
     * 
     * 
     */
    public List<AbstractDashboardSection> getChartsOrKpiCardsOrWorkflowKpiCards() {
        if (chartsOrKpiCardsOrWorkflowKpiCards == null) {
            chartsOrKpiCardsOrWorkflowKpiCards = new ArrayList<AbstractDashboardSection>();
        }
        return this.chartsOrKpiCardsOrWorkflowKpiCards;
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
        return action;
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
