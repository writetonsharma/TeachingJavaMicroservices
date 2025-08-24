package com.ncu.college.courses.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
    
@RequestMapping("/courses")
@RestController
public class CourseController 
{
    /*
     * http://localhost:9003/courses/allcourses
     */
    @GetMapping(path = "/allcourses")
    public String getAllcourses() 
    {
        System.out.println("Hello from courses controller!");
        return "Hello from courses controller!";
    }

    /*
    * http://localhost:9003/students/courses/<courseid>
    */
    @GetMapping(path = "/courses/{courseid}")
    public String getStudentByName(@PathVariable("courseid") String courseid) 
    {
        System.out.println("Hi!! " + "welcome " + courseid + " to the course!");
        return "Hi!! " + "welcome " + courseid + " to the course!";
    }

    /*
    * http://localhost:9003
    /courses/course?courseid=c101
    */
    @GetMapping(path = "/course")
    public String getStudentByNameFromRequest(@RequestParam("courseid") String courseid)
    {
        System.out.println("Hi!! Welcome to course " + courseid);
        return "Hi!! Welcome to course " + courseid;
    }

}
