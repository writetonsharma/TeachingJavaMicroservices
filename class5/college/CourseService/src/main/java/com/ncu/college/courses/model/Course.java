package com.ncu.college.courses.model;

public class Course {

    String _CourseName;
    int _Credit;
    String _CourseId;
    
        public Course() 
    {
        // Default constructor
    }

    public Course(String courseId, String courseName, Integer credit) 
    {
        this._CourseId = courseId;
        this._CourseName = courseName;
        this._Credit = credit;
    }

    // setters and getters
    public String get_CourseId() 
    {
        return _CourseId;
    }

    public void set_CourseId(String courseId) 
    {
        _CourseId = courseId;
    }

    public String get_CourseName() 
    {
        return _CourseName;
    }

    public void set_CourseName(String courseName) 
    {
        _CourseName = courseName;
    }

    public Integer get_Credit() 
    {
        return _Credit;
    }

    public void set_Credit(Integer credits) 
    {
        _Credit = credits;
    }

}
