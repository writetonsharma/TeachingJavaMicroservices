package com.ncu.college.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthServiceConfig {

    @Bean
    BCryptPasswordEncoder passwordEncoder() 
    {
        return new BCryptPasswordEncoder();
    }

}
