package com.ncu.college.authservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ncu.college.authservice.dto.SignupDto;

@Repository(value = "AuthRepository")
public class AuthRepository 
{

    JdbcTemplate _JdbcTemplate;

    @Autowired
    AuthRepository(JdbcTemplate jdbcTemplate)
    {
        this._JdbcTemplate = jdbcTemplate;
    }

    public boolean SignUp(SignupDto cred, StringBuffer error) 
    {
        try
        {
            String query = "insert into users (u_name, u_email, u_password) values (?, ?, ?)";
            _JdbcTemplate.update(query, cred.get_Name(), cred.get_Email(), cred.get_Password());
        }
        catch (Exception ex)
        {
            error.append(ex.getMessage());
            System.out.println("Error during user signup: " + error);
            return false;
        }
        return true;
    }

    public Boolean getPasswordFromEmail(String email, StringBuffer password, StringBuffer error) 
    {
        try
        {
            String query = "select u_password from users where u_email = ?";
            password.append(_JdbcTemplate.queryForObject(query, String.class, email));

        }
        catch (Exception ex)
        {
            error.append(ex.getMessage());
            System.out.println("Error during user authentication: " + error);
            return false;
        }
        return true;
    }
}
