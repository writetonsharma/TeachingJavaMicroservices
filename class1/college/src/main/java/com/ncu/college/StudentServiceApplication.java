package com.ncu.college;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.ncu.college")
public class StudentServiceApplication 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(StudentServiceApplication.class, args);
    }
}