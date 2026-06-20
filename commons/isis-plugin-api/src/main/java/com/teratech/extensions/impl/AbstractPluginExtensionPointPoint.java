package com.teratech.extensions.impl;

import com.teratech.extensions.PluginExtensionPoint;
import com.teratech.jaxb.entities.DependType;
import com.teratech.jaxb.entities.Plugin;
import com.teratech.services.JAXBService;
import com.teratech.services.PluginService;
import com.teratech.services.impl.JAXBServiceImpl;
import jakarta.xml.bind.JAXBException;
import org.pf4j.PluginWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractPluginExtensionPointPoint implements PluginExtensionPoint {

    protected final DataSource dataSource;
    protected final ApplicationContext context;
    protected final PluginService pluginService;
    protected final JAXBService jaxbService = new JAXBServiceImpl();

    protected AbstractPluginExtensionPointPoint(DataSource dataSource, ApplicationContext context, PluginService pluginService) {
        this.dataSource = dataSource;
        this.context = context;
        this.pluginService = pluginService;
    }

    /***
     * Single Extension Point per plugin for install plugin settings
     * @return
     */
    @Override
    public boolean install(PluginWrapper wrapper) throws JAXBException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        //get the projet declaration
        Plugin plugin = jaxbService.getPluginFromResources(wrapper);
        //List of uninstall plugin
        List<String> uninstallPlugins = new ArrayList<>();

        if (Objects.nonNull(plugin.getDepends())) {

            for (DependType depend : plugin.getDepends().getDepend()) {
                if (!pluginService.isInstall(depend.getId())) {
                    uninstallPlugins.add(depend.getId());
                }
            }
        }

        if (!CollectionUtils.isEmpty(uninstallPlugins)) {
            throw new IllegalStateException(String.format("These depends %s must be installed before install plugin %s", uninstallPlugins.stream().reduce("", (a, b) -> a+", "+b), wrapper.getPluginId()));
        }
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        final String[] sqlFiles = sqlFilesPath();
        if (sqlFiles != null) {
             for (String sqlFile : sqlFiles) {
                 populator.addScript(new ClassPathResource("/sql/"+sqlFile, wrapper.getPluginClassLoader()));
             }

             try {
                 populator.execute(dataSource);
                 return true;
             } catch (Exception ex) {
                 ex.printStackTrace();
                 return false;
             }
        }
       // populator.
        return false;
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
