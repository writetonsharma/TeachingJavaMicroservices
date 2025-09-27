package com.ncu.college.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ncu.college.authservice.dto.SignupDto;
import com.ncu.college.authservice.dto.ReturnDto;
import com.ncu.college.authservice.dto.AuthDto;
import com.ncu.college.authservice.repository.AuthRepository;


@Service
public class AuthService {

    private final AuthRepository _AuthRepository;
    private final PasswordEncoder _PasswordEncoder;    

    @Autowired
    AuthService(AuthRepository authRepository, PasswordEncoder passwordEncoder)
    {
        this._AuthRepository = authRepository;
        this._PasswordEncoder = passwordEncoder;
    }

    public boolean SignUp(SignupDto cred, ReturnDto response) 
    {
        cred.set_Password(_PasswordEncoder.encode(cred.get_Password()));
        StringBuffer status = new StringBuffer();
        boolean isSuccess = _AuthRepository.SignUp(cred, status);
        if (isSuccess) 
        {
            response.set_Status("User registration successful.");

        }
        else
        {
            response.set_Status("User registration failed: " + status.toString());
        }
        response.set_Email(cred.get_Email());
        return isSuccess;
    }

    public Boolean Authenticate(AuthDto cred) 
    {
        String email = cred.get_Email();
        String password = cred.get_Password();
        StringBuffer status = new StringBuffer();
        StringBuffer passwordFromDB = new StringBuffer();
        Boolean isSuccess = _AuthRepository.getPasswordFromEmail(email, passwordFromDB, status);
        if (isSuccess && _PasswordEncoder.matches(password, passwordFromDB.toString())) {
            return true;
        }
        return false;
    }

}