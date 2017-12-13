package com.murphy.springboot.controller;

import com.murphy.springboot.service.SchedualServiceOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ServiceRibbonController
 *
 * @author momo
 * @date 2017/11/2
 */
@RestController
public class ServiceFeignController {

    @Autowired
    private SchedualServiceOne schedualServiceOne;

    @Value("${service-one.domain}")
    String serviceOneDomain;

    @Value("${service-one.api.hello}")
    String serviceOneHelloUri;

    @RequestMapping("/")
    public String index(@RequestParam String name) {
        return "feign to call service url: " + serviceOneDomain + ", return: " +
                schedualServiceOne.callServiceOneIndex(name);
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return "feign to call service url: " + serviceOneDomain + serviceOneHelloUri + ", return: " +
                schedualServiceOne.callServiceOneHello(name);
    }

}
