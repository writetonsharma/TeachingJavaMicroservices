package com.ncu.college.students;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.ncu.college.students")
@EnableDiscoveryClient
public class StudentServiceApplication 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(StudentServiceApplication.class, args);
    }
}
