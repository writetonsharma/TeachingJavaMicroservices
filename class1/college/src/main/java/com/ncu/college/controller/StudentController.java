package com.ncu.college.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
    
@RequestMapping("/students")
@RestController
public class StudentController 
{

        /*
     * http://localhost:9002/students/
     */
    @GetMapping(path = "/allstudents")
    public String getAllStudents() 
    {
        System.out.println("Hello from student controller!");
        //_StudentService.getAllStudents();
        return "Hello from student controller!";
    }

        /*
     * http://localhost:9002/students/student/Naveen
     */
    @GetMapping(path = "/student/{studentname}")
    public String getStudentByName(@PathVariable("studentname") String studentname) 
    {
        System.out.println("Hi!! " + "welcome " + studentname + " to the course!");
        //_StudentService.getStudentByName(studentname);
        return "Hi!! " + "welcome " + studentname + " to the course!";
    }

        /*
     * http://localhost:9002/students/student?studentname=NaveenS
     */
    @GetMapping(path = "/student")
    public String getStudentByNameFromRequest(@RequestParam("studentname") String studentname)
    {
        System.out.println("Hi!! " + "welcome " + studentname + " to the course!");
        //_StudentService.getStudentByNameFromRequest(studentname);
        return "Hi!! " + "welcome " + studentname + " to the course!";
    }


}
