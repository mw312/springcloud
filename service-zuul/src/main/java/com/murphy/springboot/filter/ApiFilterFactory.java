package com.murphy.springboot.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author momo
 * @Description 服务过滤工厂
 */
@Component
public class ApiFilterFactory {

    @Autowired
    private CallServiceOneFilter callServiceOneFilter;

    @Autowired
    private CallServiceFeignFilter callServiceFeignFilter;

    private final static String ROUTE_SERVICE_ONE = "api-one";
    private final static String ROUTE_SERVICE_FEIGN = "api-feign";

    /**
     * 通过路由名称获取过滤服务对象
     *
     * @param routeName
     * @return
     */
    public ICallServiceFilter getServiceFilterInstanceByRouteName(String routeName) {
        switch (routeName) {
            case ROUTE_SERVICE_ONE:
                return callServiceOneFilter;
            case ROUTE_SERVICE_FEIGN:
                return callServiceFeignFilter;
            default:
                return null;
        }
    }

}