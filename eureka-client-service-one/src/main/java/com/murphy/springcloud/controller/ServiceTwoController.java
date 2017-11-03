package com.murphy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ServiceTwoController
 *
 * @author momo
 * @date 2017/11/3
 */
public class ServiceTwoController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/")
    public String home(@RequestParam String name) {
        return "service two: hi " + name + ",i am from port:" + port;
    }

}
