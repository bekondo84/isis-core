package com.teratech.isis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class SchedulingConfig {

    @Autowired
    private Environment environment;

    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(Integer.parseInt(environment.getProperty("spring.threadpooltaskscheduler.poolsize"))); // Nombre maximum de Batchs pouvant tourner en même temps
        scheduler.setThreadNamePrefix("Isis-Batch-Thread-");
        scheduler.initialize();
        return scheduler;
    }

}
