package com.abm.investments.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class DashboardResourceConfig extends ResourceConfig{

    public DashboardResourceConfig() {
        register(RequestContextFilter.class);
    }
}
