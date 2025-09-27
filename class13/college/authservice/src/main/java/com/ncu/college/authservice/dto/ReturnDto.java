package com.ncu.college.authservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReturnDto {

    @JsonProperty("Status")
    String _Status;

    @JsonProperty("Email")
    String _Email;

    public ReturnDto() {
    }

    public ReturnDto(String status, String email)
    {
        _Status = status;
        _Email = email;
    }

    // getter and setters;
    public String get_Status() {
        return _Status;
    }

    public void set_Status(String status) {
        _Status = status;
    }

    public String get_Email() {
        return _Email;
    }

    public void set_Email(String email) {
        _Email = email;
    }

}
