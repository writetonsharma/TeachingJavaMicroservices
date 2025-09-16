package com.ncu.college.courses.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class ApplicationConfig implements WebMvcConfigurer{

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) 
    {
        registry.addMapping("/**")
        .allowedOrigins("http://localhost:4200").allowCredentials(false)
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
        .allowedHeaders("*")
        .allowCredentials(true);
    }

}
