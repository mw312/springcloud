package com.murphy.springboot.controller;

import com.murphy.springboot.service.SchedualServiceOne;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/")
    public String home(@RequestParam String name) {
        return schedualServiceOne.callFromEurekaClientServiceOne(name);
    }

}
