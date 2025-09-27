package com.ncu.college.authservice.model;

public class User {

    String _UserName;
    String _Password;
    String _Name;

    public User() 
    {

    }

    public User(String userName, String password, String name) 
    {
        _UserName = userName;
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

    public String get_UserName() 
    {
        return _UserName;
    }

    public void set_UserName(String userName) 
    {
        _UserName = userName;
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
