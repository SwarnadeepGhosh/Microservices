package com.swarna.microservices.limitservice.controller;

import com.swarna.microservices.limitservice.bean.Limits;
import com.swarna.microservices.limitservice.config.PropertyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @Autowired
    PropertyConfig propertyConfig;

    @GetMapping("/limits")
    public Limits retrieveLimits(){
        return new Limits(propertyConfig.getMinimum(), propertyConfig.getMaximum());
    }
}
