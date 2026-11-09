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

        return buildDashboardData(wrapper, template);
    }

    @Override
    public DashboardData buildDashboardData(PluginWrapper wrapper, Context context) throws Exception {
        if (context == null) {
            throw new IllegalArgumentException("Config-Error: No context found for this dashboard ...");
        }

        final Dashbord dashbord = context.getDashbord();

        if (dashbord == null) {
            throw new IllegalArgumentException("Config-Error: No dashboard template found in context found ...");
        }

        final DashboardData dashboardData = new DashboardData();
        dashboardData.setName(context.getName());
        dashboardData.setLabel(i18NService.getMessage(context.getName()));
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
        if (!CollectionUtils.isEmpty(dashbord.getCharts())) {
              dashbord.getCharts().forEach((chart) -> {
                  ChartsData item = buildChartData(chart);
                  if (item.isValid()) {
                      dashboardData.addItem(item);
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
        final ChartsData chartsData = new ChartsData(chart.getName()
                , i18NService.getMessage(chart.getName())
                , (int)chart.getPosition()
                , chart.getColumns().intValue()
                , chart.isHeader());

         if (!CollectionUtils.isEmpty(chart.getItems())) {
             chart.getItems().forEach((item) -> {
                 ChartItemData chartItemDa = buildChartItem(item);
                 if (chartItemDa.isValid()) {
                     chartsData.addItem(chartItemDa);
                 }
             });
         }
        return  chartsData;
    }
    /**
     *
     * @param chartItem
     * @throws Exception
     */
    private ChartItemData buildChartItem(ChartItem chartItem)  {
         return new ChartItemData(chartItem.getId()
                 , chartItem.getName()
                 , chartItem.getAction()
                 , chartItem.getMethod()
                 , chartItem.getType().value()
                 , chartItem.getRefresh().intValue());
    }
    /**
     *
     * @param dashbord
     * @param dashboardData
     */
    private void buildWorkflowKpiCards(Dashbord dashbord, DashboardData dashboardData) {
        if (!CollectionUtils.isEmpty(dashbord.getWorkflowKpiCards())) {
            dashbord.getWorkflowKpiCards().forEach(card -> {
                WorflowKpiCardsData item = buildWorflowKpiCardsData(card);

                if (item.isValid()) {
                    dashboardData.addItem(item);
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
        WorflowKpiCardsData worflowKpiCardsData =  new WorflowKpiCardsData(worflowKpiCards.getAction(), worflowKpiCards.getMethod(), worflowKpiCards.getRefresh().intValue());

        if (!CollectionUtils.isEmpty(worflowKpiCards.getItems())) {
            worflowKpiCards.getItems().forEach((cardItem) -> {
                 final CardItemData card = new CardItemData(cardItem.getId(), cardItem.getName());
                 if (card.isValid()) {
                     worflowKpiCardsData.addItem(card);
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
        if (!CollectionUtils.isEmpty(dashbord.getKpiCards())) {
            dashbord.getKpiCards().forEach(card -> {
                    KpiCardsData e = buildKpiCardsData(wrapper, card);

                    if (e.isValid()) {
                        dashboardData.getDashbordItems().add(e);
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
           final KpiCardsData kpiCardsData = new KpiCardsData(kpiCards.getAction(), kpiCards.getMethod(), kpiCards.getRefresh().intValue());

           if (!CollectionUtils.isEmpty(kpiCards.getItems())) {
               kpiCards.getItems().forEach(card -> {
                   CardItemData item = new CardItemData(card.getId(), card.getName());
                   if (item.isValid()) {
                       kpiCardsData.addItem(item);
                   }
               });
           }
           return kpiCardsData;
    }
}
