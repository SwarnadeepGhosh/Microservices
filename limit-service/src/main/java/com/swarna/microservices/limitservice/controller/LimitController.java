package com.swarna.microservices.limitservice.controller;

import com.swarna.microservices.limitservice.bean.Limits;
import com.swarna.microservices.limitservice.config.PropertyConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LimitController {

    @Autowired
    PropertyConfig propertyConfig;

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(1, propertyConfig.getMinimum(), propertyConfig.getMaximum());
    }

    @GetMapping("/limits/{limitId}")
    public Limits findLimitsById(@PathVariable("limitId") Integer limitId) {
        try {
            if (limitId == 1 || limitId == 2) {
                log.info("Limit Id received : {}", limitId);
                return new Limits(limitId, propertyConfig.getMinimum(), propertyConfig.getMaximum());
            }
            log.info("Limit Id Not found : {}", limitId);
            throw new NullPointerException("Limit Id Not found");
        } catch (Exception e) {
            log.error("Exception Occurred: {}", e.getMessage());
            e.printStackTrace();
        }
        return new Limits();
    }
}
