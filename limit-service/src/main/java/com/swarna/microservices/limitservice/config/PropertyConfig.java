package com.swarna.microservices.limitservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("limits.service")
@Component
@Data
public class PropertyConfig {
    private int minimum;
    private int maximum;
}
