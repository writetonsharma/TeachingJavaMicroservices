package com.ncu.college.courses.repository;

import com.ncu.college.courses.irepository.ICourseRepository;

import java.util.ArrayList;
import java.util.List;

import com.ncu.college.courses.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value = "CourseRepositoryImpl")
public class CourseRepositoryImpl implements ICourseRepository{

    JdbcTemplate _JdbcTemplate;

    @Autowired
    CourseRepositoryImpl(JdbcTemplate jdbcTemplate)
    {
        this._JdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Course> GetAllCourses() 
    {
        List<Course> courses;
        try
        {
            courses = _JdbcTemplate.query("select * from course", new CourseRowMapper());
        }
        catch (Exception e)
        {
            System.out.println("Error fetching courses: " + e.getMessage());
            courses = new ArrayList<>();
        }
        return courses;
    }

    @Override
    public Course GetCourseById(String courseId) 
    {
        try
        {
            String query = "select * from course where c_id = ?";
            courseId = courseId.toLowerCase();
            return _JdbcTemplate.queryForObject(query, new CourseRowMapper(), courseId);
        }
        catch (Exception e)
        {
            System.out.println("Error fetching course by ID: " + e.getMessage());
            return null; // or throw a custom exception
        }
    }

    @Override
    public String GetCourseNameById(String courseId) 
    {
        try
        {
            courseId = courseId.toLowerCase();
            return _JdbcTemplate.queryForObject("select c_name from course where c_id = ?", 
            String.class, courseId);
        }
        catch (Exception e)
        {
            System.out.println("Error fetching course name by ID: " + e.getMessage());
            return null; // or throw a custom exception
        }
    }

    @Override
    public String GetCourseIdByName(String courseName) 
    {
        try
        {
            courseName = courseName.toLowerCase();
            return _JdbcTemplate.queryForObject("select c_id from course where c_name = ?", 
            String.class, courseName);
        }
        catch (Exception e)
        {
            System.out.println("Error fetching course ID by name: " + e.getMessage());
            return null; // or throw a custom exception
        }
    }

    @Override
    public Course GetCourseByName(String courseName) 
    {
        try
        {
            courseName = courseName.toLowerCase();
            String query = "select * from course where c_name = ?";
            return _JdbcTemplate.queryForObject(query, new CourseRowMapper(), courseName);
        }
        catch (Exception e)
        {
            System.out.println("Error fetching course by name: " + e.getMessage());
            return null; // or throw a custom exception
        }
    }

    @Override
    public Course AddCourse(Course course) 
    {
        try
        {
            String courseId = "C" + (GetCourseCount() + 100 + 1);
            course.set_CourseId(courseId);
            String sql = "INSERT INTO course (c_id, c_name, c_credit) VALUES (?, ?, ?)";
            _JdbcTemplate.update(sql, course.get_CourseId(), 
            course.get_CourseName(), course.get_Credit());
            return course;
        }
        catch (Exception e)
        {
            System.out.println("Error adding course: " + e.getMessage());
            return null; // or throw a custom exception
        }
    }

    @Override
    public Integer GetCourseCount()
    {
        try
        {
            String sql = "SELECT COUNT(*) FROM course";
            return _JdbcTemplate.queryForObject(sql, Integer.class);
        }
        catch (Exception e)
        {
            System.out.println("Error fetching course count: " + e.getMessage());
            return 0;
        }
    }


}
