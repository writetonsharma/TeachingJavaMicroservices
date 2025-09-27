package com.ncu.college;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


/*
 * http://localhost:8888/studentservice/default
 * http://localhost:8888/courseservice/default
 * http://localhost:8888/enrollmentservice/default
 * http://localhost:8888/apigateway/default
 */

@EnableConfigServer
@SpringBootApplication
public class ConfigurationServerApplication 
{    
    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(ConfigurationServerApplication.class);
        
        
        String mode = System.getenv("CONFIG_MODE");
        if ("native".equalsIgnoreCase(mode)) {
            app.setAdditionalProfiles("native");
        } else {
            app.setAdditionalProfiles("git");
        }
        app.run(args);
    }
}

