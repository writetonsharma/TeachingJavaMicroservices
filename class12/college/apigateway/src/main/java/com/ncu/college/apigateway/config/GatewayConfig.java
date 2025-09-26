package com.ncu.college.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class GatewayConfig {

    AuthHeaderFactory _AuthFactory;

    GatewayConfig(AuthHeaderFactory authFactory)
    {
        this._AuthFactory = authFactory;
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder)
    {
        return builder.routes()
            .route("courseservice", r -> r.path("/courses/**")
            .filters(f -> f.addRequestHeader(HttpHeaders.AUTHORIZATION, 
            _AuthFactory.BuildAuthHeader("courseservice")))
                .uri("lb://courseservice"))

            .route("enrollmentservice", r -> r.path("/enrollments/**")
            .filters(f -> f.addRequestHeader(HttpHeaders.AUTHORIZATION, 
            _AuthFactory.BuildAuthHeader("enrollmentservice")))
                .uri("lb://enrollmentservice"))

            .route("studentservice", r -> r.path("/students/**")
            .filters(f -> f.addRequestHeader(HttpHeaders.AUTHORIZATION, 
            _AuthFactory.BuildAuthHeader("studentservice")))
                .uri("lb://studentservice"))
                
            .build();
    }
            
}
