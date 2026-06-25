package com.teratech;

import com.teratech.extensions.ActionExtension;
import org.pf4j.Extension;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Extension
@Component
public class IsisActionExtension implements ActionExtension {

    private final ApplicationContext applicationContext;


    public IsisActionExtension(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * @return
     */
    @Override
    public ApplicationContext getApplicationContext() {
        return applicationContext;
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
        return null;
    }
}
