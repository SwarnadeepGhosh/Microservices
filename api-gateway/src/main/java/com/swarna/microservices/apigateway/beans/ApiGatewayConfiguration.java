package com.swarna.microservices.apigateway.beans;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
//       Using filters, we can add Request and Response headers and parameters to any requests or response
        return builder.routes()
                .route(p -> p
                        .path("/get") // Example
                        .filters(f -> f
                                .addRequestHeader("MyHeader", "Swarna-header")
                                .addRequestParameter("Param", "Swarna-param"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/currency-exchange/**")
                        .uri("lb://currency-exchange"))
                .route(p -> p.path("/currency-conversion/**")
                        .uri("lb://currency-conversion"))
                .route(p -> p.path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion"))
                .route(p -> p.path("/currency-conversion-new/**")
                        .filters(f -> f.rewritePath(
                                "/currency-conversion-new/(?<segment>.*)",
                                "/currency-conversion/${segment}"))
                        .uri("lb://currency-conversion"))
                .build();
    }

}