package com.teratech.extensions;

import org.pf4j.ExtensionPoint;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public interface SecurityExtensionPoint extends ExtensionPoint {

    /**
     * Permet au plugin de construire sa propre chaîne de sécurité autonome.
     * Cette chaîne doit impérativement utiliser un .securityMatcher("/mon-plugin/**")
     * pour ne pas intercepter les requêtes du Core.
     */
    SecurityFilterChain buildSecurityFilterChain(HttpSecurity http) throws Exception;
}
