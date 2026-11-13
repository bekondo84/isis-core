package com.teratech.isis.actions;

import com.teratech.actions.AbstractAction;
import com.teratech.actions.annotations.Action;
import com.teratech.actions.annotations.ActionMethod;
import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import com.teratech.metadata.*;
import com.teratech.model.cms.ActionType;
import com.teratech.utils.ApplicationConstans;
import org.pf4j.PluginManager;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.CollectionUtils;
import tools.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Objects;

@Action("backofficeDashboardAction")
public class BackofficeDashboardAction extends AbstractAction {

    /**
     *
     * @param pluginManager
     * @param flexibleSearch
     * @param persistenceManager
     * @param transactionTemplate
     */
    protected BackofficeDashboardAction(PluginManager pluginManager, FlexibleSearch flexibleSearch, PersistenceManager persistenceManager, TransactionTemplate transactionTemplate) {
        super(pluginManager, flexibleSearch, persistenceManager, transactionTemplate);
    }

    /**
     *
     * @param context
     * @return
     * @throws Exception
     */
    @ActionMethod(value = "general_kpis", scope = ActionType.POST)
    public ActionContextData kpiDashboardAction(ActionContextData context) throws Exception {
        Object data = context.get(ApplicationConstans.Actions.DATA);
        if (Objects.isNull(data)) {
            throw new IllegalArgumentException("No KPI data provided");
        }
        ObjectMapper mapper = new ObjectMapper();
        KpiCardsData kpiCardsData = mapper.convertValue(data, KpiCardsData.class);

        if (!CollectionUtils.isEmpty(kpiCardsData.getItems())) {
            for (CardItemData cardItemData : kpiCardsData.getItems()) {
                cardItemData.setValue(20.5d);
                cardItemData.setChange(3.25f);
            }
        }
        context.put(ApplicationConstans.Actions.DATA, kpiCardsData);
        return context;
    }

    @ActionMethod(value = "workflow_kpis", scope = ActionType.POST)
    public ActionContextData workflowKpis(ActionContextData context) throws Exception {
        Object data = context.get(ApplicationConstans.Actions.DATA);
        if (Objects.isNull(data)) {
            throw new IllegalArgumentException("No KPI data provided");
        }
        ObjectMapper mapper = new ObjectMapper();
        WorflowKpiCardsData kpiCardsData = mapper.convertValue(data, WorflowKpiCardsData.class);
        if (!CollectionUtils.isEmpty(kpiCardsData.getItems())) {
            for (WorkflowItemData cardItemData : kpiCardsData.getItems()) {
                cardItemData.setValue(500d);
                cardItemData.setChange(3.25f);
                cardItemData.setAmount(2500000d);
                cardItemData.setCurrency("XAF");
            }
        }
        kpiCardsData.addResume(new WorkflowKpiCardResume("Vitesse du Pipeline","TrendingUp", "bg-purple-100 dark:bg-purple-950 text-purple-700","Le temps moyen de conversion d'une fiche est de 14 jours  cette semaine."));
        kpiCardsData.addResume(new WorkflowKpiCardResume("Taux de Perte Global","TriangleExclamationPoint", "bg-amber-100 dark:bg-amber-950 text-amber-700","Attention, environ 35% de déperdition constatée entre l'étape de qualification et de proposition."));
        context.put(ApplicationConstans.Actions.DATA, kpiCardsData);
        return context;
    }

    @ActionMethod(value = "pie_test", scope = ActionType.POST)
    public ActionContextData pie_test(ActionContextData context) throws Exception {
        Object data =  context.get(ApplicationConstans.Actions.DATA);
        if (Objects.isNull(data)) {
            throw new IllegalArgumentException("No Pie data provided");
        }
        ObjectMapper mapper = new ObjectMapper();
        PieChartData pieChartData = mapper.convertValue(data, PieChartData.class);
        pieChartData.addData(new DoughnutChartData.DataSet("#ef4444", 15d, "Administration"));
        pieChartData.addData(new DoughnutChartData.DataSet("#f59e0b", 40d, "Production"));
        pieChartData.addData(new DoughnutChartData.DataSet("#10b981", 25d, "Logistique"));
        pieChartData.addData(new DoughnutChartData.DataSet("#6366f1", 20d, "Ventes"));
        context.put(ApplicationConstans.Actions.DATA, pieChartData);
        return  context;
    }

    @ActionMethod(value = "doughnut_test", scope = ActionType.POST)
    public ActionContextData doughnutChart(ActionContextData context) throws Exception {
        Object data = context.get(ApplicationConstans.Actions.DATA);
        if (Objects.isNull(data)) {
            throw new IllegalArgumentException("No Doughnut data provided");
        }
        ObjectMapper mapper = new ObjectMapper();
        DoughnutChartData doughnutChartData = mapper.convertValue(data, DoughnutChartData.class);
        doughnutChartData.addData(new DoughnutChartData.DataSet("#10b981", 65d, "En stock"));
        doughnutChartData.addData(new DoughnutChartData.DataSet("#ef4444", 10d, "En rupture"));
        doughnutChartData.addData(new DoughnutChartData.DataSet("#f59e0b", 15d, "En commande"));
        doughnutChartData.addData(new DoughnutChartData.DataSet("#6366f1", 10d, "Réservé"));
        context.put(ApplicationConstans.Actions.DATA, doughnutChartData);
        return context;
    }

    @ActionMethod(value = "line_test" , scope = ActionType.POST)
    public ActionContextData line_test (ActionContextData context) throws Exception {
        Object data = context.get(ApplicationConstans.Actions.DATA);
        if (Objects.isNull(data)) {
            throw new IllegalArgumentException("No Line data provided");
        }
        ObjectMapper mapper = new ObjectMapper();
        LineChartData lineChartData = mapper.convertValue(data, LineChartData.class);

        lineChartData.setLabels(Arrays.asList("Jan", "Fev", "Mar", "Avr", "Mai", "Juin"));
        LineChartData.LineChartItemData dataset = new LineChartData.LineChartItemData("Année 2026 (€)", "rgba(147, 51, 234, 0.05)", "#9333ea", "#9333ea");
        dataset.setValues(Arrays.asList(30000d, 45000d, 28000d, 60000d, 75000d, 90000d));
        lineChartData.addDataset(dataset);
        LineChartData.LineChartItemData dataset2 = new LineChartData.LineChartItemData("Budget 2026 (€)", "transparent", "#cbd5e1", "#cbd5e1");
        dataset2.setValues(Arrays.asList(25000d, 38000d, 30000d, 52000d, 68000d, 81000d));
        lineChartData.addDataset(dataset2);
        context.put(ApplicationConstans.Actions.DATA, lineChartData);
        return context;
    }

    @ActionMethod(value = "bar_test", scope = ActionType.POST)
    public ActionContextData bar_test (ActionContextData context) throws Exception {
        Object data = context.get(ApplicationConstans.Actions.DATA);
        if (Objects.isNull(data)) {
            throw new IllegalArgumentException("No Bar data provided");
        }
        ObjectMapper mapper = new ObjectMapper();
        BarChartData barChartData = mapper.convertValue(data, BarChartData.class);
        BarChartData.DataSet dataSet = new BarChartData.DataSet();
        barChartData.setLabels(Arrays.asList("Q1", "Q2", "Q3", "Q4"));
        dataSet.setValues(Arrays.asList(100000d, 120000d, 140000d, 180000d))
                .setLabel("Objectif (€)")
                .setBgColor("#3b82f6");
        barChartData.addDataSet(dataSet);
        dataSet = new BarChartData.DataSet("Réalisé (€)", "#10b981");
        dataSet.setValues(Arrays.asList(95000d, 125000d, 135000d, 190000d));
        barChartData.addDataSet(dataSet);
        context.put(ApplicationConstans.Actions.DATA, barChartData);
        return context;
    }

}
