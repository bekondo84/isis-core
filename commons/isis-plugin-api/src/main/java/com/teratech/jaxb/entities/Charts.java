//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.11.12 à 10:19:41 AM CET 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java pour Charts complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Charts"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.isis.cm/config/dashboard}AbstractDashboardSection"&gt;
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element name="barChart" type="{http://www.isis.cm/config/dashboard}BarChart"/&gt;
 *         &lt;element name="pieChart" type="{http://www.isis.cm/config/dashboard}PieChart"/&gt;
 *         &lt;element name="doughnutChart" type="{http://www.isis.cm/config/dashboard}DoughnutChart"/&gt;
 *         &lt;element name="lineChart" type="{http://www.isis.cm/config/dashboard}LineChart"/&gt;
 *         &lt;element name="activityLogs" type="{http://www.isis.cm/config/dashboard}ActivityLogs"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Charts", propOrder = {
    "barChartOrPieChartOrDoughnutChart"
})
public class Charts
    extends AbstractDashboardSection
{

    @XmlElements({
        @XmlElement(name = "barChart", type = BarChart.class),
        @XmlElement(name = "pieChart", type = PieChart.class),
        @XmlElement(name = "doughnutChart", type = DoughnutChart.class),
        @XmlElement(name = "lineChart", type = LineChart.class),
        @XmlElement(name = "activityLogs", type = ActivityLogs.class)
    })
    protected List<ChartItem> barChartOrPieChartOrDoughnutChart;

    /**
     * Gets the value of the barChartOrPieChartOrDoughnutChart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the barChartOrPieChartOrDoughnutChart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBarChartOrPieChartOrDoughnutChart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActivityLogs }
     * {@link BarChart }
     * {@link DoughnutChart }
     * {@link LineChart }
     * {@link PieChart }
     * 
     * 
     */
    public List<ChartItem> getBarChartOrPieChartOrDoughnutChart() {
        if (barChartOrPieChartOrDoughnutChart == null) {
            barChartOrPieChartOrDoughnutChart = new ArrayList<ChartItem>();
        }
        return this.barChartOrPieChartOrDoughnutChart;
    }

}
