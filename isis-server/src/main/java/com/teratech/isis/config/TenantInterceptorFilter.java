package com.teratech.isis.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class TenantInterceptorFilter implements Filter {

    private static final String TENANT_HEADER = "X-Tenant-ID";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (request instanceof HttpServletRequest httpRequest) {
            String tenantId = httpRequest.getHeader(TENANT_HEADER);

            if (tenantId != null && !tenantId.trim().isEmpty()) {
                // Nettoyage sommaire de la chaîne pour éviter des injections SQL dans le "SET search_path"
                String sanitizedTenant = tenantId.replaceAll("[^a-zA-Z0-9_]", "");
                TenantContext.setCurrentTenant(sanitizedTenant);
            } else {
                TenantContext.setCurrentTenant(TenantContext.DEFAULT_TENANT);
            }
        }

        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            System.out.println("=== CRASH DANS LA REQUETE : " + e.getMessage());
            e.printStackTrace(); // Force l'affichage de la pile d'exécution
            throw e;
        } finally {
            // CRUCIAL : On vide le ThreadLocal à la fin de la requête pour éviter
            // que le thread réutilisé par Tomcat ne conserve le tenant d'un autre client.
            if (request.getAttribute("jakarta.servlet.error.exception") == null) {
                TenantContext.clear();
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}
