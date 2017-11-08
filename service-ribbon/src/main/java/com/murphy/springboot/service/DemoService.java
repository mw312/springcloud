package com.murphy.springboot.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * DemoService
 *
 * @author momo
 * @date 2017/11/3
 */
@Service
public class DemoService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 当service-one服务不可用或者线程堵塞时，SpringCloud使用Hystrix组件实现断路器模式，保证调用者不会因此而瘫痪。
     * 如果不采用断路器，由于服务与服务之间的依赖性，故障会传播，会对整个微服务系统造成灾难性的严重后果，这就是服务故障的“雪崩”效应。
     * 本demo采用restTemplate+Ribbon实现服务之间的调用
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "callServiceError")
    public String callServiceOne(String name) {
        return "to call service one, return: " + restTemplate.getForObject("http://service-one/?name=" + name, String.class);
    }

    public String callServiceError(String name) {
        return "oh," + name + ",sorry,error!";
    }

}
