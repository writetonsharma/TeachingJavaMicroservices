package com.ncu.college.enrollments.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ncu.college.enrollments.irepository.IEnrollmentRepository;
import com.ncu.college.enrollments.model.Enrollment;
import java.util.ArrayList;
import java.util.List;


@Repository
public class EnrollmentRepositoryImpl implements IEnrollmentRepository 
{
    JdbcTemplate _JdbcTemplate;

    @Autowired
    public EnrollmentRepositoryImpl(JdbcTemplate jdbcTemplate) 
    {
        this._JdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Enrollment> GetAllEnrollments()
    {
        List<Enrollment> enrollments;
        try
        {
            enrollments = _JdbcTemplate.query("select * from enrollment", new EnrollmentRowMapper());
        }
        catch (Exception e)
        {
            System.out.println("Error fetching enrollments: " + e.getMessage());
            throw new RuntimeException("Error fetching enrollments", e);
        }
        return enrollments;
    }

    @Override
    public List<Enrollment> GetEnrollmentByRollNumber(String rollNumber) 
    {
        List<Enrollment> enrollments = new ArrayList<>();
        try
        {
            enrollments = _JdbcTemplate.query("select * from enrollment where s_id = ?"
            , new EnrollmentRowMapper(), rollNumber);
        }
        catch (Exception e)
        {
            System.out.println("Error fetching enrollments by ID: " + e.getMessage());
            throw new RuntimeException("Error fetching enrollments by ID", e);
        }
        return enrollments;
    }

    @Override
    public List<Enrollment> GetEnrollmentByCourseId(String courseId) 
    {
        List<Enrollment> enrollments = new ArrayList<>();
        try
        {
            enrollments = _JdbcTemplate.query("select * from enrollment where c_id = ?"
            , new EnrollmentRowMapper(), courseId);
        }
        catch (Exception e)
        {
            System.out.println("Error fetching enrollments by course ID: " + e.getMessage());
            throw new RuntimeException("Error fetching enrollments by course ID", e);
        }
        return enrollments;
    }

    @Override
    public void AddEnrollment(Enrollment enrollment) 
    {
        try
        {
            String sql = "INSERT INTO enrollment (s_id, c_id) VALUES (?, ?)";
            _JdbcTemplate.update(sql, enrollment.get_StudentRollNumber(), enrollment.get_CourseId());
        }
        catch (Exception e)
        {
            System.out.println("Error adding enrollment: " + e.getMessage());
            throw new RuntimeException("Error adding enrollment", e);
        }
    }

    @Override
    public void DeleteEnrollmentByRollNumber(String rollNumber) 
    {
        try
        {
            String sql = "DELETE FROM enrollment WHERE s_id = ?";
            _JdbcTemplate.update(sql, rollNumber);
        }
        catch (Exception e)
        {
            System.out.println("Error deleting enrollment: " + e.getMessage());
            throw new RuntimeException("Error deleting enrollment", e);
        }
    }

}
