package com.murphy.springboot.service.impl;

import com.murphy.springboot.service.SchedualServiceOne;
import org.springframework.stereotype.Component;

/**
 * SchedualServiceOneHystric
 *
 * @author momo
 * @date 2017/11/8
 */
@Component
public class SchedualServiceOneHystric implements SchedualServiceOne {

    @Override
    public String callFromEurekaClientServiceOne(String name) {
        return "oh, feign call " + name + " error!";
    }

}
