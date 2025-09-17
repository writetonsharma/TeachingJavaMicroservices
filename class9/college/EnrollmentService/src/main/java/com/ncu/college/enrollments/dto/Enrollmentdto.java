package com.ncu.college.enrollments.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Enrollmentdto
{

    @JsonProperty("studentrollnumber")
    String _StudentRollNumber;

    @JsonProperty("courseid")
    String _CourseId;

    public Enrollmentdto()
    {
        // Default constructor
    }

    public Enrollmentdto(String rollnumber, String courseid) 
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
