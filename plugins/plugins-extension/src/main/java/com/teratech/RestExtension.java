package com.teratech;

import com.teratech.extensions.impl.AbstractRestExtensionPoint;
import org.pf4j.Extension;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Extension
public class RestExtension extends AbstractRestExtensionPoint {



    private final ApplicationContext applicationContext;

    /**
     *
     * @param applicationContext
     */
    public RestExtension(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
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
        return applicationContext;
    }
}
