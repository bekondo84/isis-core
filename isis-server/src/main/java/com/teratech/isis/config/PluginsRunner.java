package com.teratech.isis.config;

import com.teratech.dao.FlexibleSearch;
import com.teratech.extensions.JobPerformable;
import com.teratech.isis.dao.PluginDao;
import com.teratech.isis.services.impl.DynamicJobSchedulerService;
import com.teratech.model.PluginModel;
import com.teratech.model.jobs.CronJobModel;
import com.teratech.tools.persistence.RestrictionsContainer;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.pf4j.PluginManager;
import org.pf4j.PluginState;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.CollectionUtils;

import java.util.*;


@Configuration
public class PluginsRunner implements CommandLineRunner {

    private final PluginManager pluginManager;
    private final RestPluginManager restPluginManager;
    private final FlexibleSearch flexibleSearch;
    private final org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping requestMappingHandlerMapping;
    private final Logger logger;
    private final Environment env ;
    private final PluginDao pluginDao;
    private final DynamicJobSchedulerService jobSchedulerService;

    /**
     *
     * @param pluginManager
     * @param restPluginManager
     * @param requestMappingHandlerMapping
     * @param logger
     */
    public PluginsRunner(PluginManager pluginManager, RestPluginManager restPluginManager, FlexibleSearch flexibleSearch, org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping requestMappingHandlerMapping, Logger logger, Environment env, PluginDao pluginDao, DynamicJobSchedulerService jobSchedulerService) {
        this.pluginManager = pluginManager;
        this.restPluginManager = restPluginManager;
        this.flexibleSearch = flexibleSearch;
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
        this.logger = logger;
        this.env = env;
        this.pluginDao = pluginDao;
        this.jobSchedulerService = jobSchedulerService;
    }


    @Override
    public void run(String... args) throws Exception {
        logger.info("DEMARRAGE DES PLUGINS EN COURS !!!!!!!!");
          pluginManager.loadPlugins();
          pluginManager.startPlugins();
          //startInstallPlugins();
          //pluginManager.startPlugins();
          // /!\ AJOUT : Enregistrement des endpoints HTTP des plugins
          restPluginManager.registerPluginControllers();
          logger.info("LES PLUGINS CORRECTEMENT DEMARREES !");

          //Demarrage des Cron
          RestrictionsContainer container = RestrictionsContainer.newInstance();
          container.addEq("actif", Boolean.TRUE);
          List<CronJobModel> cronJobs = flexibleSearch.doSearch(CronJobModel.class, container, new HashMap<>(), new HashSet<>(), 0, -1);

          for (CronJobModel cronJob : cronJobs) {
              List<JobPerformable> jobExtensions = pluginManager.getExtensions(JobPerformable.class, cronJob.getPlugin().getId());

              if (CollectionUtils.isEmpty(jobExtensions)) {
                  logger.error(String.format("No JobPerformable extension found for plugin %s", cronJob.getPlugin().getId()));
                  continue;
              }
             Optional<JobPerformable> jobPerformable = jobExtensions.stream().filter(job -> StringUtils.isNotBlank(job.job()) && job.job().equals(cronJob.getJob())).findAny();

              if (jobPerformable.isEmpty()) {
                  logger.error(String.format("No JobPerformable extension of name %s found for plugin %s", cronJob.getJob(), cronJob.getPlugin().getId()));
                  continue;
              }
          }
          //Initialize Batch pools
        jobSchedulerService.initAllScheduledJobs();
        // 2. LE TEST : Affichage de TOUTES les routes connues par Spring
        if (BooleanUtils.toBoolean(env.getProperty("spring.web.show-routes"))) {
            logger.info("\n========== [CATALOGUE OF SPRING ROAD] ==========");
            requestMappingHandlerMapping.getHandlerMethods().forEach((key, value) -> {
                logger.info("[Active Road] -> " + key + " | Associate component : " + value.getShortLogMessage());
            });
            System.out.println("=================================================================\n");
        }
    }

    private void startInstallPlugins() throws IllegalAccessException {
        List<PluginModel> installPlugins = pluginDao.getInstallPlugins(0, -1);

        if (installPlugins != null && !installPlugins.isEmpty()) {

            for (PluginModel pg : installPlugins) {

                if (Objects.nonNull(pluginManager.getPlugin(pg.getId()))) {
                    PluginState state = pluginManager.startPlugin(pg.getId());
                    if (state.isStarted()) {
                        logger.info(String.format("[CORE-] - Plugin %s has started succesfuly", pg.getId()));
                    } else if (state.isFailed()){
                        logger.info(String.format("[CORE-] - Plugin %s has failed start", pg.getId()));
                    }
                }
            }
        }
    }
}
