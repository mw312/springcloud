package com.murphy.springcloud.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

    private static final Log log = LogFactory.getLog(ServiceOneController.class);

    @Value("${server.port}")
    String port;

    @Value("${spring.cloud.config.testname}")
    String test;

    @RequestMapping("/")
    public String index(@RequestParam String name) {
        log.info("spring cloud config of test -- name:" + test);
        return "service one: hi " + name + ",i am from port:" + port;
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return "service one: hello " + name + "!";
    }

    /**
     * 模拟大量请求时并发造成线程堵塞
     *
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/sleep")
    public String sleep() throws InterruptedException {
        Thread.sleep(100000);
        return "service one: do sleep,i am from port:" + port;
    }

}
