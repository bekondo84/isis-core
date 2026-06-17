package com.teratech.isis.config;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

//@Configuration
public class JpaMultiTenantConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource,
            SchemaMultiTenantConnectionProvider connectionProvider,
            TenantIdentifierResolver tenantResolver) {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.teratech");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> jpaProperties = new HashMap<>();

        // 1. On indique la stratégie (Sous Hibernate 6, la valeur "DATABASE" ou "SCHEMA" passe par une chaîne)
        jpaProperties.put("hibernate.multiTenancy", "SCHEMA");

        // 2. On passe le fournisseur de connexion (Clé : "hibernate.multi_tenant_connection_provider")
        jpaProperties.put(AvailableSettings.MULTI_TENANT_CONNECTION_PROVIDER, connectionProvider);

        // 3. On passe le résolveur de tenant (Clé : "hibernate.tenant_identifier_resolver")
        jpaProperties.put(AvailableSettings.MULTI_TENANT_IDENTIFIER_RESOLVER, tenantResolver);

        // Sécurité impérative
        jpaProperties.put(AvailableSettings.HBM2DDL_AUTO, "none");

        em.setJpaPropertyMap(jpaProperties);
        return em;
    }

}
