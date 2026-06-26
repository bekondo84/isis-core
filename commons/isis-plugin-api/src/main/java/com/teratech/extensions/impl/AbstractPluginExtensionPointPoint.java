package com.teratech.extensions.impl;

import com.teratech.exceptions.ApplicationException;
import com.teratech.exceptions.ModelServiceException;
import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import com.teratech.extensions.PluginExtensionPoint;
import com.teratech.jaxb.entities.DependType;
import com.teratech.jaxb.entities.Plugin;
import com.teratech.model.PluginModel;
import com.teratech.services.JAXBService;
import com.teratech.services.MenuNodeService;
import com.teratech.services.impl.JAXBServiceImpl;
import jakarta.xml.bind.JAXBException;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractPluginExtensionPointPoint implements PluginExtensionPoint {

    protected final DataSource dataSource;
    protected final ApplicationContext context;
    protected final FlexibleSearch flexibleSearch;
    protected final MenuNodeService menuNodeService;
    protected final PersistenceManager persistenceManager;
    protected final PluginManager pluginManager;
    protected final TransactionTemplate transactionTemplate;
    protected final JAXBService jaxbService = new JAXBServiceImpl();

    protected AbstractPluginExtensionPointPoint(DataSource dataSource, ApplicationContext context, FlexibleSearch flexibleSearch, MenuNodeService menuNodeService, PersistenceManager persistenceManager, PluginManager pluginManager, TransactionTemplate transactionTemplate) {
        this.dataSource = dataSource;
        this.context = context;
        this.flexibleSearch = flexibleSearch;
        this.menuNodeService = menuNodeService;
        this.persistenceManager = persistenceManager;
        this.pluginManager = pluginManager;
        this.transactionTemplate = transactionTemplate;
    }

    /***
     * Single Extension Point per plugin for install plugin settings
     * @return
     */
    @Override
    public boolean install(PluginWrapper wrapper) throws ApplicationException {

        try {
            return transactionTemplate.execute(status -> {

                try {
                    installSteps(wrapper);
                    return true;
                } catch (NoSuchFieldException | InvocationTargetException | IllegalAccessException |
                         InstantiationException | NoSuchMethodException | JAXBException | ModelServiceException e) {
                    throw new RuntimeException(e);
                }
            });

        }catch (RuntimeException e) {
            throw  new ApplicationException(e);
        }

    }

    /**
     * @param wrapper
     * @return
     */
    @Override
    public boolean uninstall(PluginWrapper wrapper) throws ApplicationException {

        try {
            return transactionTemplate.execute(status -> {

                try {
                    Plugin plugin = jaxbService.getPluginFromResources(wrapper);

                    if (Objects.isNull(plugin)) {
                        String.format("No description file found for plugin with ID %s and version %s", wrapper.getPluginId(), wrapper.getDescriptor().getVersion());
                    }
                    //Clean plugin data
                    dataPopulator(uninstallSqlFiles(), wrapper);
                    //Clean Menu Data
                    menuNodeService.cleanPluginMenus(wrapper);
                    // Mark the plugin as install
                    PluginModel pluginModel = flexibleSearch.find(new PluginModel(wrapper.getPluginId(), wrapper.getDescriptor().getVersion()));
                    assert Objects.nonNull(pluginModel) : String.format("No plugin found with ID %s and version %s", wrapper.getPluginId(), wrapper.getDescriptor().getVersion());
                    pluginModel.setInstall(Boolean.FALSE);
                    pluginModel.setInstaldate(null);
                    persistenceManager.save(pluginModel);
                    return true;
                } catch (JAXBException | IllegalAccessException | ModelServiceException | NoSuchFieldException |
                         InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                    throw  new RuntimeException(e);
                }

            });
        } catch (RuntimeException e) {
            throw new ApplicationException(e);
        }

    }


    /**
     *
     * @param wrapper
     * @throws JAXBException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws ModelServiceException
     */
    private void installSteps(PluginWrapper wrapper) throws JAXBException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, InstantiationException, NoSuchMethodException, ModelServiceException {
        //get the projet declaration
        Plugin plugin = jaxbService.getPluginFromResources(wrapper);
        //List of uninstall plugin
        List<String> uninstallPlugins = new ArrayList<>();

        if (Objects.nonNull(plugin.getDepends())) {

            for (DependType depend : plugin.getDepends().getDepend()) {
                PluginWrapper dependWrapper = pluginManager.getPlugin(depend.getId());

                if (Objects.isNull(dependWrapper))
                    continue;
                PluginModel pluginModel = flexibleSearch.find(new PluginModel(dependWrapper.getPluginId(), dependWrapper.getDescriptor().getVersion()));

                if (Objects.isNull(pluginModel))
                    throw new IllegalStateException(String.format("Plugin Configuration Error : No plugin found with ID %s", depend));

                if (!pluginModel.isInstall()) {
                    uninstallPlugins.add(depend.getId());
                }
            }
        }

        if (!CollectionUtils.isEmpty(uninstallPlugins)) {
            throw new IllegalStateException(String.format("These depends %s must be installed before install plugin %s", uninstallPlugins.stream().reduce("", (a, b) -> a+", "+b), wrapper.getPluginId()));
        }
        //Populate plugin data
        dataPopulator(installSqlFiles(), wrapper) ;
        //Create Plugin nodes
        menuNodeService.buildMenus(wrapper);
        // Mark the plugin as install
        PluginModel pluginModel = flexibleSearch.find(new PluginModel(wrapper.getPluginId(), wrapper.getDescriptor().getVersion()));
        assert Objects.nonNull(pluginModel) : String.format("No plugin found with ID %s and version %s", wrapper.getPluginId(), wrapper.getDescriptor().getVersion());
        pluginModel.setInstall(Boolean.TRUE);
        pluginModel.setInstaldate(new Date());
        persistenceManager.save(pluginModel);
    }


    /**
     *
     * @param strings
     * @param wrapper
     */
    private void dataPopulator(String[] strings, PluginWrapper wrapper) {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        if (strings != null) {
            for (String sqlFile : strings) {
                populator.addScript(new ClassPathResource("/sql/"+sqlFile, wrapper.getPluginClassLoader()));
            }
            populator.execute(dataSource);
        }
    }


    /**
     * @return the current plugin name
     */
    @Override
    public String plugin() {
        return "";
    }

    /**
     * Return the spring application context
     *
     * @return
     */
    @Override
    public ApplicationContext getContext() {
        return context;
    }
}
