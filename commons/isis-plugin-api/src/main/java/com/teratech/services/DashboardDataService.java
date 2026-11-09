package com.teratech.services;

import com.teratech.jaxb.entities.Context;
import com.teratech.metadata.DashboardData;
import com.teratech.metadata.MetaData;
import com.teratech.model.cms.DashboardModel;
import org.pf4j.PluginWrapper;

public interface DashboardDataService {

    /**
     *
     * @param dashboard
     * @return
     */
    DashboardData buildDashboardData(DashboardModel dashboard) throws Exception;
    /**
     *
     * @param wrapper
     * @param context
     * @return
     * @throws Exception
     */
    DashboardData buildDashboardData(PluginWrapper wrapper, Context context) throws Exception;
}
