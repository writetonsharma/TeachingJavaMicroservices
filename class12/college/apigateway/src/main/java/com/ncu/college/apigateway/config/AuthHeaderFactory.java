package com.ncu.college.apigateway.config;


import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthHeaderFactory {

    @Value("${courseservice.auth.username}")
    String _CourseUsername;
    @Value("${courseservice.auth.password}")
    String _CoursePassword;

    @Value("${enrollmentservice.auth.username}")
    String _EnrollmentUsername;
    @Value("${enrollmentservice.auth.password}")
    String _EnrollmentPassword;

    @Value("${studentservice.auth.username}")
    String _StudentUsername;
    @Value("${studentservice.auth.password}")
    String _StudentPassword;

    String BuildAuthHeader(String serviceName)
    {
        String username = "";
        String password = "";

        if(serviceName == "courseservice")
        {
            username = _CourseUsername; 
            password = _CoursePassword;
        }
        else if(serviceName == "enrollmentservice")
        {
            username = _EnrollmentUsername; 
            password = _EnrollmentPassword;            
        }
        else if(serviceName == "studentservice")
        {
            username = _StudentUsername; 
            password = _StudentPassword;
        }

        String auth = username + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
    }
}
