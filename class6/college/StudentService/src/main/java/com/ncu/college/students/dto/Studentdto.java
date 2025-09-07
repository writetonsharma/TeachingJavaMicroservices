package com.ncu.college.students.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;

public class Studentdto 
{
    @JsonProperty("rollnumber")
    String _RollNumber;

    @JsonProperty("name")
    String _Name;

    @JsonProperty("year")
    String _Year;

    @JsonProperty("email")
    @Email(message = "Please provide a valid email address") String _Email;

    @JsonProperty("courses")
    List<String> _Courses;


    public Studentdto() 
    {
        this._Name = "";
        this._Year = "";
        this._Email = "";
        this._RollNumber = "";
        this._Courses = null;
    }

    public Studentdto(String RollNumber, String Name, String Year, String Email, List<String> Courses) 
    {
        this._RollNumber = RollNumber;
        this._Name = Name;
        this._Year = Year;
        this._Email = Email;
        this._Courses = Courses;
    }

    public String get_RollNumber()
    {
        return _RollNumber;
    }

    public void set_RollNumber(String rollNumber) 
    {
        _RollNumber = rollNumber;
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
