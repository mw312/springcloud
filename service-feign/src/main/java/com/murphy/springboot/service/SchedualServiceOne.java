package com.murphy.springboot.service;

import com.murphy.springboot.service.impl.SchedualServiceOneHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by momo on 2017/11/6.
 */
@FeignClient(value = "${service-one.domain}", fallback = SchedualServiceOneHystric.class)
public interface SchedualServiceOne {

    /**
     * 本demo采用Feign实现服务之间的调用
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String callFromEurekaClientServiceOne(@RequestParam(value = "name") String name);

}
