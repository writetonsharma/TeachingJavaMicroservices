package com.ncu.college.enrollments.repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ncu.college.enrollments.model.Enrollment;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class EnrollmentRowMapper implements RowMapper<Enrollment>
{

    @Override
    @Nullable
    public Enrollment mapRow(@Nullable ResultSet rs, int rowNum) throws SQLException 
    {
        if (rs == null) {
            return null; // Handle null ResultSet
        }
            String studentRollNumber = rs.getString("s_id");
            String courseId = rs.getString("c_id");
            return new Enrollment(studentRollNumber, courseId);
    }
}
