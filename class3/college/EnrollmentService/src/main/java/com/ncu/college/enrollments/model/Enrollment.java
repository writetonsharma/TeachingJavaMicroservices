package com.ncu.college.enrollments.model;

public class Enrollment
{
    String _StudentRollNumber;
    String _CourseId;

    public Enrollment() 
    {
        // Default constructor
    }

    public Enrollment(String rollnumber, String courseid) 
    {
        _StudentRollNumber = rollnumber;
        _CourseId = courseid;
    }

    // setters and getters
    public String get_StudentRollNumber() 
    {
        return _StudentRollNumber;
    }

    public void set_StudentRollNumber(String studentRollNumber) 
    {
        _StudentRollNumber = studentRollNumber;
    }

    public String get_CourseId() 
    {
        return _CourseId;
    }

    public void set_CourseId(String courseId) 
    {
        _CourseId = courseId;
    }

}
