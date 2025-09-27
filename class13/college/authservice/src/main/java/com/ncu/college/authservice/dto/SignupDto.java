package com.ncu.college.authservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignupDto {

    @JsonProperty("email")
    String _Email;

    @JsonProperty("password")
    String _Password;

    @JsonProperty("name")
    String _Name;

    public SignupDto() 
    {

    }

    public SignupDto(String email, String password, String name) 
    {
        _Email = email;
        _Password = password;
        _Name = name;
    }

    public String get_Name() 
    {
        return _Name;
    }

    public void set_Name(String name) 
    {
        _Name = name;
    }

    public String get_Email() 
    {
        return _Email;
    }

    public void set_Email(String email) 
    {
        _Email = email;
    }

    public String get_Password() 
    {
        return _Password;
    }

    public void set_Password(String password)
    {
        _Password = password;
    }

}
