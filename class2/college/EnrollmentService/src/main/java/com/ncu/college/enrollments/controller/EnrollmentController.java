package com.ncu.college.enrollments.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
    
@RequestMapping("/enrollments")
@RestController
public class EnrollmentController 
{
    /*
     * http://localhost:9004/enrollments/allenrollments
     */
    @GetMapping(path = "/allenrollments")
    public String getAllEnrollments() 
    {
        System.out.println("Hello from enrollment controller!");
        return "Hello from enrollment controller!";
    }

    /*
    * http://localhost:9004/enrollments/enrollment/<rollnumber>
    */
    @GetMapping(path = "/enrollment/{rollnumber}")
    public String getEnrollmentByStudentRollNumber(@PathVariable("rollnumber") String rollnumber) 
    {
        System.out.println("Hi!! Here is enrollment information for the student " + rollnumber);
        return "Hi!! Here is enrollment information for the student " + rollnumber;
    }

}
