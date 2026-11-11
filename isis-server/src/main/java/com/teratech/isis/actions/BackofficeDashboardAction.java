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
}
