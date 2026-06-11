package com.teratech.extensions;

import org.pf4j.ExtensionPoint;
import org.springframework.context.ApplicationContext;

public interface IsisExtensionPoint extends ExtensionPoint {

    /**
     *
     * @return the current plugin name
     */
    String plugin() ;

    /**
     * Return the spring application context
     * @return
     */
    ApplicationContext getContext() ;


}
