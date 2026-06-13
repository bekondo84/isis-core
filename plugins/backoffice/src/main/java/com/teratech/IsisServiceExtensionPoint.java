package com.teratech;

import com.teratech.extensions.ServiceExtensionPoint;
import org.pf4j.Extension;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Extension
@Component
public class IsisServiceExtensionPoint implements ServiceExtensionPoint {

    private final ApplicationContext context;

    public IsisServiceExtensionPoint(ApplicationContext context) {
        this.context = context;
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
        return context;
    }
}
