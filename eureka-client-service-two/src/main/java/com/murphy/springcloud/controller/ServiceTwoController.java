package com.murphy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ServiceTwoController
 *
 * @author momo
 * @date 2017/11/2
 */
@RestController
public class ServiceTwoController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/")
    public String index(@RequestParam String name) {
        return "service two: hi " + name + ",i am from port:" + port;
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return "service two: hello " + name + "!";
    }

}
