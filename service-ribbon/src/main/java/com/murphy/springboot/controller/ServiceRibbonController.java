package com.murphy.springboot.controller;

import com.murphy.springboot.service.DemoService;
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
public class ServiceRibbonController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/")
    public String index(@RequestParam String name) {
        return demoService.callServiceOneIndex(name);
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return demoService.callServiceOneHello(name);
    }

}
