package com.murphy.springboot.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author imkie
 */
@Component
@ConfigurationProperties(prefix = "zuul")
public class ApiFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(ApiFilter.class);

    @Autowired
    private ApiFilterFactory apiFilterFactory;

    private Map<String, Map<String, String>> routes = new HashMap<>();

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        String routeKey;
        for (Map.Entry<String, Map<String, String>> entry : routes.entrySet()) {
            routeKey = entry.getKey();
            if (-1 != request.getRequestURL().toString().indexOf(routeKey)) {
                ICallServiceFilter filter = apiFilterFactory.getServiceFilterInstanceByRouteName(routeKey);
                return null != filter ? filter.execute() : null;
            }
        }
        logger.info("no match!");
        return null;
    }

    public Map<String, Map<String, String>> getRoutes() {
        return routes;
    }

    public void setRoutes(Map<String, Map<String, String>> routes) {
        this.routes = routes;
    }

}
