package com.teratech.isis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hold the database scheme holder
 */
public class TenantContext {

    private static final Logger log = LoggerFactory.getLogger(TenantContext.class);
    private static final ThreadLocal<String> CURRENT_TENANT = new ThreadLocal<>();
    public static final String DEFAULT_TENANT = "public";

    public static void setCurrentTenant(String tenantId) {
        log.debug("Définition du tenant courant : {}", tenantId);
        CURRENT_TENANT.set(tenantId);
    }

    public static String getCurrentTenant() {
        return CURRENT_TENANT.get();
    }

    public static void clear() {
        log.debug("Nettoyage du contexte de tenant");
        CURRENT_TENANT.remove();
    }
}
