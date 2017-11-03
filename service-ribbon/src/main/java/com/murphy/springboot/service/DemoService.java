package com.murphy.springboot.service;

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

    public String callServiceOne(String name) {
        return restTemplate.getForObject("http://service-one/?name=" + name, String.class);
    }

}
