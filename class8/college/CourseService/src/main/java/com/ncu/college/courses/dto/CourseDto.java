package com.ncu.college.courses.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CourseDto {

    @JsonProperty("coursename")
    String _CourseName;

    @JsonProperty("credits")
    int _Credit;

        CourseDto() 
    {

    }

    public CourseDto(String courseName, int credit) 
    {
        _CourseName = courseName;
        _Credit = credit;
    }

    public String get_CourseName() 
    {
        return _CourseName;
    }

    public void set_CourseName(String courseName) 
    {
        _CourseName = courseName;
    }

    public int get_Credit() 
    {
        return _Credit;
    }

    public void set_Credit(int credit) 
    {
        _Credit = credit;
    }

}
