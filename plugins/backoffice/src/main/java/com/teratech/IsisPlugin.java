package com.teratech;

import com.teratech.plugin.AbstractSpringPlugin;
import org.pf4j.PluginWrapper;

public class IsisPlugin extends AbstractSpringPlugin {
    /**
     * Spring Plugin constructor
     *
     * @param wrapper
     */
    public IsisPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    /**
     * Return the list of packages to scan for entities found
     *
     * @return
     */
    @Override
    public String[] scanPackages() {
        return new String[] {"com.teratech"};
    }
}
