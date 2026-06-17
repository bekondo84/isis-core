package com.teratech.isis.config;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

//@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver<String> {
    private static final String DEFAULT_TENANT = "public";

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenantId = TenantContext.getCurrentTenant();
        // Force l'affichage dans la console pour déboguer
        System.out.println("===> Hibernate demande le tenant actuel. Résolution : " + tenantId);
        return tenantId != null ? tenantId : TenantContext.DEFAULT_TENANT;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
