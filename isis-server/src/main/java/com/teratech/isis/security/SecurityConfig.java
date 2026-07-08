package com.teratech.isis.security;

import com.teratech.extensions.SecurityExtensionPoint;
import com.teratech.utils.ApplicationConstans;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private PluginManager pluginManager;
    @Autowired
    private JwtAuthenticationFilter jwtAuthFilter;

    @Bean
    public List<SecurityFilterChain> pluginSecurityFilterChains (HttpSecurity http) throws Exception {
        List<SecurityFilterChain> chains = new ArrayList<>();

        for (PluginWrapper wrapper : pluginManager.getPlugins()) {
            // On récupère tous los plugins qui ont déclaré leur propre référentiel / login
            List<SecurityExtensionPoint> extensions = pluginManager.getExtensions(SecurityExtensionPoint.class, wrapper.getPluginId());
            for (SecurityExtensionPoint ext : extensions) {
                chains.add(ext.buildSecurityFilterChain(http, wrapper.getPluginId()));
            }
        }


        return chains;
    }

    @Bean
    @Order(10)
    public SecurityFilterChain coreApiSecurityFilterChain (HttpSecurity http) throws Exception {

       http
                .securityMatcher("/api/**") // S'applique à toutes les API par défaut
                .csrf(csrf -> csrf.disable())
               .authorizeHttpRequests(auth -> auth
                       .requestMatchers("/api/auth/**", "/api/public/**").permitAll()
                       .anyRequest().hasRole(ApplicationConstans.Security.USER_APPLI_ROLE)
               ).sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                //.userDetailsService(coreUserDetailsService);
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    /*// =========================================================================
    // 3. CHAÎNE WEB PAR DÉFAUT DU CORE (Form Login - Employés)
    // =========================================================================
    @Bean
    @Order(20) // Dernière chaîne de secours pour l'application web standard
    public SecurityFilterChain coreWebSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/**") // Intercepte tout le reste
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/css/**", "/js/**").permitAll()
                        .anyRequest().hasRole("APP_USER") // Seuls les employés accèdent au backoffice du Core
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/dashboard", true)
                        .permitAll()
                )
                *//*.userDetailsService(coreUserDetailsService)*//*; // Utilise la base Employés

        return http.build();
    }*/
}
