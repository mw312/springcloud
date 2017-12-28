package com.murphy.springcloud.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

    private final Log log = LogFactory.getLog(this.getClass());

    @Value("${server.port}")
    String port;

    @Value("${test}")
    String test;

    @Value("${spring.datasource.url}")
    String url;

    @RequestMapping("/")
    public String index(@RequestParam String name) {
        log.info("spring cloud config center of test:" + test);
        log.debug("spring cloud config of spring.datasource.url:" + url);
        return "service two: hi " + name + ",i am from port:" + port + ";test:" + test;
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return "service two: hello " + name + "!";
    }

}
