package com.swarna.microservices.currencyexchange.beans;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircuitBreakerController {

    @GetMapping("/sample-api")
//    @Retry(name = "default", fallbackMethod = "hardcodedResponse")
//    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
//    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    @RateLimiter(name = "default")
    public String sampleApi(){
        log.info("Sample API call received");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://dummy-url:8080", String.class);
        return forEntity.getBody();
    }

    public String hardcodedResponse(Exception ex) {
        return "fallback-response";
    }

}
