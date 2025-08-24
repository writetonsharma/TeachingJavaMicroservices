package com.ncu.college.courses;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.ncu.college.courses")
public class CourseServiceApplication 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(CourseServiceApplication.class, args);
    }
}
