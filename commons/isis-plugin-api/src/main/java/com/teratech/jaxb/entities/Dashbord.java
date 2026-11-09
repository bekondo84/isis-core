//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.11.09 à 03:02:43 PM CET 
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
 *       &lt;choice&gt;
 *         &lt;element name="charts" type="{http://www.isis.cm/config/dashboard}Charts" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="kpiCards" type="{http://www.isis.cm/config/dashboard}KpiCards" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="workflowKpiCards" type="{http://www.isis.cm/config/dashboard}WorflowKpiCards" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "charts",
    "kpiCards",
    "workflowKpiCards"
})
@XmlRootElement(name = "dashbord", namespace = "http://www.isis.cm/config/dashboard")
public class Dashbord {

    @XmlElement(namespace = "http://www.isis.cm/config/dashboard")
    protected List<Charts> charts;
    @XmlElement(namespace = "http://www.isis.cm/config/dashboard")
    protected List<KpiCards> kpiCards;
    @XmlElement(namespace = "http://www.isis.cm/config/dashboard")
    protected List<WorflowKpiCards> workflowKpiCards;
    @XmlAttribute(name = "action", required = true)
    protected String action;

    /**
     * Gets the value of the charts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the charts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCharts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link com.isis.generated.Charts }
     * 
     * 
     */
    public List<Charts> getCharts() {
        if (charts == null) {
            charts = new ArrayList<Charts>();
        }
        return this.charts;
    }

    /**
     * Gets the value of the kpiCards property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the kpiCards property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKpiCards().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link com.isis.generated.KpiCards }
     * 
     * 
     */
    public List<KpiCards> getKpiCards() {
        if (kpiCards == null) {
            kpiCards = new ArrayList<KpiCards>();
        }
        return this.kpiCards;
    }

    /**
     * Gets the value of the workflowKpiCards property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the workflowKpiCards property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWorkflowKpiCards().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link com.isis.generated.WorflowKpiCards }
     * 
     * 
     */
    public List<WorflowKpiCards> getWorkflowKpiCards() {
        if (workflowKpiCards == null) {
            workflowKpiCards = new ArrayList<WorflowKpiCards>();
        }
        return this.workflowKpiCards;
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
