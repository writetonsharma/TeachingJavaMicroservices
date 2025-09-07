package com.ncu.college.students.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.ncu.college.students.dto.Studentdto;
import com.ncu.college.students.service.StudentService;


@RestController
@RequestMapping("/students")
public class StudentController 
{

    StudentService _StudentService;
    

    @Autowired
    public StudentController(StudentService studentService) 
    {
        this._StudentService = studentService;
    }

    @GetMapping(path = "/")
    public List<Studentdto> GetAllStudents() 
    {
        try
        {
            return _StudentService.GetAllStudents();
        }
        catch (Exception e)
        {
            System.out.println("Error fetching students: " + e.getMessage());
            throw new RuntimeException("Error fetching students", e);
        }
    }

    @GetMapping(path = "/student/{rollNumber}")
    public Studentdto GetStudentByRollNumber(@PathVariable("rollNumber") String rollNumber) 
    {
        try
        {
            return _StudentService.GetStudentById(rollNumber);
        }
        catch (Exception e)
        {
            System.out.println("Error fetching student by roll number: " + e.getMessage());
            throw new RuntimeException("Error fetching student by roll number", e);
        }
    }

    @GetMapping(path = "/student")
    public Studentdto GetStudentByName(@RequestParam("studentname") String studentname)
    {
        try
        {
            return _StudentService.GetStudentByName(studentname);
        }
        catch (Exception e)
        {
            System.out.println("Error fetching student by name: " + e.getMessage());
            throw new RuntimeException("Error fetching student by name", e);
        }
    }

    @PostMapping("/student")
    public String AddStudent(@RequestBody Studentdto student) 
    {
        try
        {
            String rollnumber = _StudentService.AddStudent(student);
            return rollnumber;
        }
        catch (Exception e)
        {
            System.out.println("Error adding student: " + e.getMessage());
            throw new RuntimeException("Error adding student", e);
        }
    }

    @DeleteMapping("/student/{studentname}")
    public void DeleteStudentByName(@PathVariable("studentname") String studentName)
    {
        try
        {
            _StudentService.DeleteStudentByName(studentName);
        }
        catch (Exception e)
        {
            System.out.println("Error deleting student: " + e.getMessage());
            throw new RuntimeException("Error deleting student", e);
        }
    }
}
