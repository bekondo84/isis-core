package com.teratech.isis.config;


import jakarta.persistence.EntityManagerFactory;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableTransactionManagement
public class ServerJpaConfig {

    private static final Logger LOG = LoggerFactory.getLogger(ServerJpaConfig.class);

    private final PluginManager pluginManager;

    @Autowired
    public ServerJpaConfig(PluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    @Bean(name = "entityManagerFactory")
    public LocalEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource) {
        final List<String> packagesToScan = new ArrayList<>();
        LocalEntityManagerFactoryBean entityManagerFactoryBean = new LocalEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        packagesToScan.add("com.teratech.isis");
        //2. Dynamic read package to scan for each plugin
        for (PluginWrapper wrapper : pluginManager.getPlugins()) {
            final String pluginPackage = wrapper.getPlugin().getClass().getPackageName();
            packagesToScan.add(pluginPackage);
            LOG.info(String.format("[ISIS-SERVER] Le package %s enregistré pour le plugin %s", pluginPackage, wrapper.getPluginId()));
        }
        entityManagerFactoryBean.setPackagesToScan(packagesToScan.toArray(new String[0]));

        return entityManagerFactoryBean;
    }

    @Bean(name = "coreTransactionManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory, DataSource dataSource) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        txManager.setDataSource(dataSource);
        return txManager;
    }

    @Bean(name = "coreTransactionTemplate")
    public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager) {
        return new TransactionTemplate(transactionManager);
    }
}
