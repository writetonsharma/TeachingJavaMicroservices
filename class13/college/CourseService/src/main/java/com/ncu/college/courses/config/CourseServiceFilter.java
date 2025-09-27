package com.ncu.college.courses.config;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CourseServiceFilter extends OncePerRequestFilter 
{

    @Value("${apigateway.shared.secret}")
    String _SharedSecret;

    @Override
    protected void doFilterInternal(
        @NonNull HttpServletRequest request,
        @NonNull HttpServletResponse response,
        @NonNull FilterChain filterChain
    ) throws ServletException, IOException 
    {
        final String secret = request.getHeader("X-API-GATEWAY-SECRET");
        if (!_SharedSecret.equals(secret)) 
        {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        filterChain.doFilter(request, response);
    }
    
}
