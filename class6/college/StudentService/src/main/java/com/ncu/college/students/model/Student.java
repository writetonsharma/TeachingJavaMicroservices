package com.ncu.college.students.model;
import java.util.List;

public class Student
{

    String _RollNumber;
    String _Name;
    String _Year;
    String _Email;
    List<String> _Courses;

    public Student() 
    {
        // Default constructor
    }

    public Student(String rollNo, String name, 
                    String year, String email,
                    List<String> courses) 
    {
        _RollNumber = rollNo;
        _Name = name;
        _Year = year;
        _Email = email;
        _Courses = courses;
    }

    // setters and getters
    public String get_RollNumber()
    {
        return _RollNumber;
    }

    public void set_RollNumber(String rollNo) 
    {
        _RollNumber = rollNo;
    }

    public String get_Name() 
    {
        return _Name;
    }

    public void set_Name(String name) 
    {
        _Name = name;
    }

    public String get_Year() 
    {
        return _Year;
    }

    public void set_Year(String year) 
    {
        _Year = year;
    }

    public String get_Email() 
    {
        return _Email;
    }

    public void set_Email(String email) 
    {
        _Email = email;
    }

    public List<String> get_Courses() 
    {
        return _Courses;
    }

    public void set_Courses(List<String> courses)
    {
        _Courses = courses;
    }

}
