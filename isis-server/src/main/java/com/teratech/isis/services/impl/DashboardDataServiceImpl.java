package com.teratech.isis.services.impl;

import com.teratech.jaxb.entities.*;
import com.teratech.metadata.*;
import com.teratech.model.cms.DashboardModel;
import com.teratech.services.DashboardDataService;
import com.teratech.services.I18NService;
import com.teratech.services.JAXBService;
import com.teratech.services.impl.JAXBServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.Objects;

@Service
public class DashboardDataServiceImpl implements DashboardDataService {

    @Autowired
    private I18NService i18NService;
    @Autowired
    private PluginManager pluginManager;
    //@Autowired
    private JAXBService  jaxbService = new JAXBServiceImpl();

    @Override
    public DashboardData buildDashboardData(DashboardModel dashboard) throws Exception{
        DashboardData dashboardData = new DashboardData();
        dashboardData.setId(dashboard.getCode());
        dashboardData.setLabel(i18NService.getMessage(dashboard.getCode()));
        dashboardData.setName(dashboard.getDescription());

       final String pluginid = Objects.nonNull(dashboard.getPlugin()) ? dashboard.getPlugin().getId() : null;
        PluginWrapper wrapper = null ;
       if (StringUtils.isNotBlank(pluginid)) {
           wrapper = pluginManager.getPlugin(pluginid);

           if (wrapper == null) {
               throw new IllegalArgumentException("Plugin " + pluginid + " not found");
           }
       }

        Context template = jaxbService.getTemplateFromResources(wrapper, dashboard.getTemplate());

       if (Objects.isNull(template)) {
           throw new IllegalArgumentException("Template " + dashboard.getTemplate() + " not found");
       }

        return buildDashboardData(wrapper, dashboard, template);
    }

    @Override
    public DashboardData buildDashboardData(PluginWrapper wrapper, DashboardModel dashboardModel, Context context) throws Exception {
        if (context == null) {
            throw new IllegalArgumentException("Config-Error: No context found for this dashboard ...");
        }

        final Dashbord dashbord = context.getDashbord();

        if (dashbord == null) {
            throw new IllegalArgumentException("Config-Error: No dashboard template found in context found ...");
        }

        final DashboardData dashboardData = new DashboardData();
        dashboardData.setId(dashboardModel.getCode());
        dashboardData.setName(dashboardModel.getCode());
        dashboardData.setLabel(i18NService.getMessage(dashboardModel.getCode()));
        //Builds KPI cards sections
        buildKpiCardsData(wrapper, dashbord, dashboardData);
        buildWorkflowKpiCards(dashbord, dashboardData);
        buildCharts(dashbord, dashboardData);

        //Tri des sections par ordre croissant de position
        if (!CollectionUtils.isEmpty(dashboardData.getDashbordItems())) {
            dashboardData.getDashbordItems().sort(new Comparator<AbstractDashboardSectionData>() {

                @Override
                public int compare(AbstractDashboardSectionData o1, AbstractDashboardSectionData o2) {
                    return o1.getPosition().compareTo(o2.getPosition());
                }
            });
        }
        return dashboardData;
    }

    private void buildCharts(Dashbord dashbord, DashboardData dashboardData) {
        if (!CollectionUtils.isEmpty(dashbord.getChartsOrKpiCardsOrWorkflowKpiCards())) {
              dashbord.getChartsOrKpiCardsOrWorkflowKpiCards().stream()
                      .filter(item -> item instanceof Charts)
                      .forEach((chart) -> {
                          ChartsData item = buildChartData((Charts) chart);
                          if (item.isValid()) {
                              dashboardData.addItem(item);
                          } else  {
                              throw new IllegalArgumentException("Config-Error: invalid Charts config: name, columns and position are required ..."+item.getItems());
                          }
                      });
        }
    }

    /**
     *
     * @param chart
     * @return
     */
    private ChartsData buildChartData(Charts chart) {
        if (StringUtils.isBlank(chart.getName())) {
            throw new IllegalArgumentException("Config-Error: No name provided for charts ...");
        }
        final ChartsData chartsData = new ChartsData(chart.getName()
                , i18NService.getMessage(chart.getName())
                , (int)chart.getPosition()
                , (int)chart.getColumns()
                , chart.isHeader());

         if (!CollectionUtils.isEmpty(chart.getBarChartOrPieChartOrDoughnutChart())) {
             chart.getBarChartOrPieChartOrDoughnutChart().forEach((item) -> {
                 if (item instanceof LineChart) {
                     LineChartData itemData = buildLineChartData((LineChart)item);
                     if (itemData.isValid()) {
                         chartsData.addItem(itemData);
                     } else {
                         throw new IllegalArgumentException("Config-Error:  Invalid LineChart config: id, refresh, action and method are required...");
                     }
                 } else if (item instanceof BarChart) {
                     BarChartData itemData = buildBarChartData((BarChart) item);
                     if (itemData.isValid()) {
                         chartsData.addItem(itemData);
                     } else {
                         throw new IllegalArgumentException("Config-Error:  Invalid BarChart config: id, refresh, action and method are required...");
                     }
                 }  else if (item instanceof DoughnutChart) {
                     DoughnutChartData itemData = buildDoughnutChartData((DoughnutChart)item);
                     if (itemData.isValid()) {
                         chartsData.addItem(itemData);
                     } else {
                         throw new IllegalArgumentException("Config-Error:  Invalid DoughnutChart config: id, refresh, action and method are required...");
                     }
                 } else if (item instanceof PieChart) {
                     PieChartData itemData = buildPieChartData((PieChart)item);
                     if (itemData.isValid()) {
                         chartsData.addItem(itemData);
                     }  else {
                         throw new IllegalArgumentException("Config-Error:  Invalid PieChart config: id, refresh, action and method are required...");
                     }
                 } else if (item instanceof ActivityLogs) {
                     ActivityLogsData activityLogsData = buildActivityLogsData((ActivityLogs)item);
                     if (activityLogsData.isValid()) {
                         chartsData.addItem(activityLogsData);
                     } else {
                         throw new IllegalArgumentException("Config-Error:  Invalid ActivityLogs config: id, refresh, action and method are required...");
                     }
                 }

             });
         }
        return  chartsData;
    }

    private ActivityLogsData buildActivityLogsData(ActivityLogs item) {
        ActivityLogsData activityLogsData = new ActivityLogsData(item.getId(), i18NService.getMessage(item.getId()));
        activityLogsData.setAction(item.getAction())
                .setMethod(item.getMethod())
                .setRefresh(item.getRefresh().intValue())
                .setColor(item.getColor())
                .setIcon(item.getIcon())
                .setId(item.getId())
                .setIcon(item.getIcon())
                .setColor(item.getColor());
        return activityLogsData;
    }

    private PieChartData buildPieChartData(PieChart item) {
        PieChartData pieChartData = new PieChartData(item.getId(), i18NService.getMessage(item.getId()));
        pieChartData.setAction(item.getAction())
                .setMethod(item.getMethod())
                .setRefresh(item.getRefresh().intValue())
                .setColor(item.getColor())
                .setIcon(item.getIcon())
                .setId(item.getId());
        return pieChartData;
    }

    private DoughnutChartData buildDoughnutChartData(DoughnutChart item) {
        DoughnutChartData doughnutChartData = new DoughnutChartData(item.getId(), i18NService.getMessage(item.getId()));
        doughnutChartData.setAction(item.getAction())
                .setMethod(item.getMethod())
                .setRefresh(item.getRefresh().intValue())
                .setColor(item.getColor())
                .setIcon(item.getIcon())
                .setId(item.getId());
        return doughnutChartData;
    }


    private LineChartData buildLineChartData(LineChart item) {
        final LineChartData lineChartData = new LineChartData(item.getId(), i18NService.getMessage(item.getId()));
        lineChartData.setType("line")
                .setAction(item.getAction())
                .setMethod(item.getMethod())
                .setRefresh(item.getRefresh().intValue())
                .setColor(item.getColor())
                .setIcon(item.getIcon())
                .setId(item.getId())
                .setLabel(i18NService.getMessage(item.getId()));
        return  lineChartData;
    }

    private BarChartData buildBarChartData(BarChart barChart) {
        final BarChartData barChartData = new BarChartData();
        barChartData.setType("bar")
                .setAction(barChart.getAction())
                .setMethod(barChart.getMethod())
                .setRefresh(barChart.getRefresh().intValue())
                .setColor(barChart.getColor())
                .setIcon(barChart.getIcon())
                .setId(barChart.getId())
                .setLabel(i18NService.getMessage(barChart.getId()));
        return  barChartData;
    }
    /**
     *
     * @param chartItem
     * @throws Exception
     */
    private ChartItemData buildChartItem(ChartItem chartItem)  {
         return new ChartItemData(chartItem.getId()
                 , i18NService.getMessage( chartItem.getId())
                 , chartItem.getAction()
                 , chartItem.getMethod()
                 , chartItem.getRefresh().intValue());
    }
    /**
     *
     * @param dashbord
     * @param dashboardData
     */
    private void buildWorkflowKpiCards(Dashbord dashbord, DashboardData dashboardData) {
        if (!CollectionUtils.isEmpty(dashbord.getChartsOrKpiCardsOrWorkflowKpiCards())) {
            dashbord.getChartsOrKpiCardsOrWorkflowKpiCards().stream()
                    .filter(item -> item instanceof  WorflowKpiCards).forEach(card -> {
                WorflowKpiCardsData item = buildWorflowKpiCardsData((WorflowKpiCards) card);

                if (item.isValid()) {
                    dashboardData.addItem(item);
                }  else {
                    throw new IllegalArgumentException("Config-Error:  Invalid WorflowKpiCards config: name, position, columns, refresh, action and method are required...");
                }
            });
        }
    }

    /**
     *
     * @param worflowKpiCards
     * @return
     */
    private WorflowKpiCardsData buildWorflowKpiCardsData(WorflowKpiCards worflowKpiCards)  {
        if (StringUtils.isBlank(worflowKpiCards.getName())) {
            throw new IllegalArgumentException("Config-Error: No name provided for workflowKpiCards ...");
        }
        WorflowKpiCardsData worflowKpiCardsData =  new WorflowKpiCardsData(worflowKpiCards.getAction(), worflowKpiCards.getMethod(), worflowKpiCards.getRefresh().intValue());
        worflowKpiCardsData.setName(worflowKpiCards.getName());
        worflowKpiCardsData.setLabel(i18NService.getMessage(worflowKpiCards.getName()));
        //worflowKpiCardsData.setResume(worflowKpiCards.get);
        worflowKpiCardsData.setIcon(worflowKpiCards.getIcon());
        worflowKpiCardsData.setPosition((int) worflowKpiCards.getPosition());
        worflowKpiCardsData.setColumns((int) worflowKpiCards.getColumns());
        worflowKpiCardsData.setUnit(worflowKpiCards.getUnit());
        worflowKpiCardsData.setLabel(i18NService.getMessage(worflowKpiCards.getName()));
        if (!CollectionUtils.isEmpty(worflowKpiCards.getItems())) {
            worflowKpiCards.getItems().forEach((cardItem) -> {
                 final WorkflowItemData card = new WorkflowItemData(cardItem.getId(), i18NService.getMessage(cardItem.getId()));
                 card.setIcon(cardItem.getIcon());
                 card.setStatecolor(cardItem.getText());
                 card.setColor(cardItem.getColor());
                 card.setCurrency(cardItem.getCurrency());
                 if (card.isValid()) {
                     worflowKpiCardsData.addItem(card);
                 }  else {
                     throw new IllegalArgumentException("Config-Error:  Invalid CardItem config: id is required...");
                 }
            });
        }
        return worflowKpiCardsData;
    }


    /**
     *
     * @param wrapper
     * @param dashbord
     * @param dashboardData
     * @throws Exception
     */
    private void buildKpiCardsData(PluginWrapper wrapper, Dashbord dashbord, DashboardData dashboardData) throws Exception {
        if (!CollectionUtils.isEmpty(dashbord.getChartsOrKpiCardsOrWorkflowKpiCards())) {
            dashbord.getChartsOrKpiCardsOrWorkflowKpiCards().stream()
                    .filter(item -> item instanceof KpiCards).forEach(card -> {
                    KpiCardsData e = buildKpiCardsData(wrapper, (KpiCards) card);

                    if (e.isValid()) {
                        dashboardData.getDashbordItems().add(e);
                    }  else {
                        throw new IllegalArgumentException("Config-Error:  Invalid CardItem config: name, position, columns, action, method and refresh is required...");
                    }
                });
        }
    }

    /**
     *
     * @param wrapper
     * @param kpiCards
     * @return
     * @throws Exception
     */
    private KpiCardsData buildKpiCardsData(PluginWrapper wrapper, KpiCards kpiCards)  {
            if (StringUtils.isBlank(kpiCards.getName())) {
                throw new IllegalArgumentException("Config-Error: No name provided for kpiCards ...");
            }
           final KpiCardsData kpiCardsData = new KpiCardsData(kpiCards.getAction(), kpiCards.getMethod(), kpiCards.getRefresh().intValue());
           kpiCardsData.setName(kpiCards.getName());
           kpiCardsData.setLabel(i18NService.getMessage(kpiCards.getName()));
           kpiCardsData.setRefresh(kpiCards.getRefresh().intValue());
           kpiCardsData.setPosition((int) kpiCards.getPosition());
           kpiCardsData.setColumns((int)kpiCards.getColumns());
           if (!CollectionUtils.isEmpty(kpiCards.getItems())) {
               kpiCards.getItems().forEach(card -> {
                   CardItemData item = new CardItemData(card.getId(), i18NService.getMessage(card.getId()));
                   item.setColor(card.getColor());
                   item.setIcon(card.getIcon());
                   item.setCurrency(card.getCurrency());
                   if (item.isValid()) {
                       kpiCardsData.addItem(item);
                   }  else {
                       throw new IllegalArgumentException("Config-Error:  Invalid CardItem config: id is required...");
                   }
               });
           }
           return kpiCardsData;
    }
}
