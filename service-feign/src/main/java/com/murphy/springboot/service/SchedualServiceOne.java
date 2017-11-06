package com.murphy.springboot.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by momo on 2017/11/6.
 */
@FeignClient(value = "service-one")
public interface SchedualServiceOne {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String callFromEurekaClientServiceOne(@RequestParam(value = "name") String name);

}
