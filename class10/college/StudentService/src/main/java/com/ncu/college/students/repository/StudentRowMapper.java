package com.ncu.college.students.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import com.ncu.college.students.model.Student;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class StudentRowMapper implements RowMapper<Student>
{

    @Override
    @Nullable
    public Student mapRow(@Nullable ResultSet rs, int rowNum) throws SQLException 
    {
        if (rs == null) {
            return null; // Handle null ResultSet
        }
        Student student = new Student();
        student.set_RollNumber(rs.getString("s_rollnumber"));
        student.set_Name(rs.getString("s_name"));
        student.set_Year(rs.getString("s_year"));
        student.set_Email(rs.getString("s_email"));
        return student;
    }

}
