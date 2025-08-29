package com.ncu.college.enrollments.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncu.college.enrollments.dto.Enrollmentdto;
import com.ncu.college.enrollments.service.EnrollmentService;


@RestController
@RequestMapping("/enrollments")
public class EnrollmentController 
{
    EnrollmentService _EnrollmentService;
    

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) 
    {
        this._EnrollmentService = enrollmentService;
    }

    @GetMapping(path = "/")
    public List<Enrollmentdto> getAllEnrollments() 
    {
        try
        {
            return _EnrollmentService.GetAllEnrollments();
        }
        catch (Exception e)
        {
            System.out.println("Error fetching enrollments: " + e.getMessage());
            throw new RuntimeException("Error fetching enrollments", e);
        }
    }

    @GetMapping(path = "/enrollment/rollnumber/{rollnumber}")
    public List<Enrollmentdto> getEnrollmentByRollNumber(@PathVariable("rollnumber") String rollNumber) 
    {
        try
        {
            return _EnrollmentService.GetEnrollmentByRollNumber(rollNumber);
        }
        catch (Exception e)
        {
            System.out.println("Error fetching enrollment by roll number: " + e.getMessage());
            throw new RuntimeException("Error fetching enrollment by roll number", e);
        }
    }

    @GetMapping(path = "/enrollment/courseid/{courseid}")
    public List<Enrollmentdto> getEnrollmentByCourseId(@PathVariable("courseid") String courseId)
    {
        try
        {
            return _EnrollmentService.GetEnrollmentByCourseId(courseId);
        }
        catch (Exception e)
        {
            System.out.println("Error fetching enrollment by course ID: " + e.getMessage());
            throw new RuntimeException("Error fetching enrollment by course ID", e);
        }
    }

    @PostMapping("/enrollment")
    public void addEnrollment(@RequestBody List<Enrollmentdto> enrollment) 
    {
        try
        {
            _EnrollmentService.AddEnrollment(enrollment);
        }
        catch (Exception e)
        {
            System.out.println("Error adding enrollment: " + e.getMessage());
            throw new RuntimeException("Error adding enrollment", e);
        }
    }

    @DeleteMapping("/enrollment/{rollnumber}")
    public void DeleteEnrollmentByRollNumber(@PathVariable("rollnumber") String rollNumber)
    {
        try
        {
            _EnrollmentService.DeleteEnrollmentByRollNumber(rollNumber);
        }
        catch (Exception e)
        {
            System.out.println("Error deleting enrollment: " + e.getMessage());
            throw new RuntimeException("Error deleting enrollment", e);
        }
    }
}
