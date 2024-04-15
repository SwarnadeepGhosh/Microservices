package com.swarna.microservices.currencyconversion.beans;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange", url = "${currency-exchange.url}")
// Feign client will talk to Eureka, pickup the current instances of currency exchange, and do the load balancing between them.
// All these magic happens just by removing this url.
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to);

}