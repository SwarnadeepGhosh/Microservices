package com.swarna.microservices.currencyconversion.beans;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController
public class CurrencyConversionController {

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
    ) {

        return CurrencyConversion.builder()
                .id(120L)
                .from("")
                .to("")
                .quantity(new BigDecimal(1))
                .conversionMultiple(new BigDecimal(1))
                .totalCalculatedAmount(new BigDecimal(1))
                .environment("feign")
                .build();

    }

}

