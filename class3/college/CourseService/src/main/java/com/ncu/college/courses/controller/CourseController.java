package com.ncu.college.courses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.ncu.college.courses.service.CourseService;
import com.ncu.college.courses.dto.CourseDto;
import java.util.*;
    
@RequestMapping("/courses")
@RestController
public class CourseController 
{
    CourseService _CourseService;

    @Autowired
    CourseController(CourseService courseService)
    {
        this._CourseService = courseService;
    }
    @GetMapping(path = "/")
    public List<CourseDto> getAllCourses() 
    {
        return _CourseService.GetAllCourses();
    }

    @GetMapping(path = "/course/{courseId}")
    public CourseDto getCourseById(@PathVariable("courseId") String courseId) 
    {
        return _CourseService.GetCourseById(courseId);
    }

    @GetMapping(path = "/course/coursename/{courseid}")
    public String getCourseNameById(@PathVariable("courseid") String courseid)
    {
        return _CourseService.GetCourseNameById(courseid);
    }

    @GetMapping(path = "/course/courseid/{coursename}")
    public String getCourseIdByName(@PathVariable("coursename") String coursename)
    {
        return _CourseService.GetCourseIdByName(coursename);
    }

    @GetMapping(path = "/course")
    public CourseDto getCourseByName(@RequestParam("coursename") String coursename)
    {
        return _CourseService.GetCourseByName(coursename);
    }

    @PostMapping("/course")
    public CourseDto addCourse(@RequestBody CourseDto course) 
    {
        _CourseService.AddCourse(course);
        return course;
    }

}
