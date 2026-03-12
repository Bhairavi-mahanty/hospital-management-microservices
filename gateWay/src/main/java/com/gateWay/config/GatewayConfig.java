package com.gateWay.config;

import com.gateWay.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("doctor-service", r -> r.path("/api/doctor/**")
                        .filters(f -> f.filter(jwtAuthenticationFilter))
                        .uri("lb://doctor-service"))
                .route("patient-service", r -> r.path("/api/patient/**")
                        .filters(f -> f.filter(jwtAuthenticationFilter))
                        .uri("lb://patient-service"))
                .route("appointment-service", r -> r.path("/api/appointment/**")
                        .filters(f -> f.filter(jwtAuthenticationFilter))
                        .uri("lb://appointment-service"))
                .build();
    }
}