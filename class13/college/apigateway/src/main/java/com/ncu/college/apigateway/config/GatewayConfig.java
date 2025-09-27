package com.ncu.college.apigateway.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableWebFluxSecurity
public class GatewayConfig {


    GatewayConfig()
    {
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeExchange(exchange -> exchange
                .pathMatchers("/auth/**").permitAll()
                .pathMatchers("/actuator/**").permitAll()
                .anyExchange().permitAll()
            )
            .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
            .formLogin(ServerHttpSecurity.FormLoginSpec::disable);
        return http.build();
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder)
    {
        return builder.routes()
            .route("courseservice", r -> r.path("/courses/**")
                .uri("lb://courseservice"))

            .route("enrollmentservice", r -> r.path("/enrollments/**")
                .uri("lb://enrollmentservice"))

            .route("studentservice", r -> r.path("/students/**")
                .uri("lb://studentservice"))

            .route("authservice", r -> r.path("/auth/**")
                .uri("lb://authservice"))
                
            .build();
    }
        
    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}
