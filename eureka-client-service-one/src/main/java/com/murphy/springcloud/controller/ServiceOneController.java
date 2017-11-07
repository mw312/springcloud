package com.murphy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ServiceOneController
 *
 * @author momo
 * @date 2017/11/3
 */
@RestController
public class ServiceOneController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/")
    public String home(@RequestParam String name) {
        return "service one: hi " + name + ",i am from port:" + port;
    }

    @RequestMapping("/one")
    public String one() throws InterruptedException {
        Thread.sleep(10000000);
        return "service one: call one,i am from port:" + port;
    }

}
