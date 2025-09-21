package com.ncu.college.servicediscovery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ApplicationConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
            .requestMatchers("/eureka/**").authenticated()
            .anyRequest().permitAll()
            )
            .httpBasic(httpBasic -> {})
            .cors(cors -> {});

            return http.build();
    }
}
