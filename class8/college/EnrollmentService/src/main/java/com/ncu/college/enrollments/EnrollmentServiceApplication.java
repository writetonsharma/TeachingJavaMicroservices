package com.ncu.college.enrollments;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.ncu.college.enrollments")
@EnableDiscoveryClient
public class EnrollmentServiceApplication 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(EnrollmentServiceApplication.class, args);
    }
}
