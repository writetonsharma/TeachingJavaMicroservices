package com.ncu.college.students.repository;

import com.ncu.college.students.irepository.IStudentRepository;
import com.ncu.college.students.model.Student;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository(value = "StudentRepositoryImpl")
public class StudentRepositoryImpl implements IStudentRepository 
{
    JdbcTemplate _JdbcTemplate;

    @Autowired
    public StudentRepositoryImpl(JdbcTemplate jdbcTemplate) 
    {
        this._JdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> GetAllStudents() 
    {
        List<Student> students;
        try
        {
            students = _JdbcTemplate.query("select * from student", new StudentRowMapper());
        }
        catch (Exception e)
        {
            System.out.println("Error fetching students: " + e.getMessage());
            throw new RuntimeException("Error fetching students", e);
        }
        return students;
    }

    @Override
    public Student GetStudentById(String RollNo) 
    {
        try
        {
            RollNo = RollNo.toLowerCase();
            return _JdbcTemplate.queryForObject("select * from student where s_rollnumber = ?", 
            new StudentRowMapper(), RollNo);
        }
        catch (Exception e)
        {
            System.out.println("Error fetching student by ID: " + e.getMessage());
            throw new RuntimeException("Error fetching student by ID", e);
        }
    }

    @Override
    public Student GetStudentByName(String studentName) 
    {
        try
        {
            studentName = studentName.toLowerCase();
            return _JdbcTemplate.queryForObject("select * from student where s_name = ?", 
            new StudentRowMapper(), studentName);
        }
        catch (Exception e)
        {
            System.out.println("Error fetching student by name: " + e.getMessage());
            throw new RuntimeException("Error fetching student by name", e);
        }
    }

    @Override
    public Student AddStudent(Student student) 
    {
        try
        {
            _JdbcTemplate.update("INSERT INTO student (s_rollnumber, s_name, s_year, s_email) VALUES (?, ?, ?, ?)",
            student.get_RollNumber(), student.get_Name().toLowerCase(), student.get_Year(), student.get_Email());
            return student;
        }
        catch (Exception e)
        {
            System.out.println("Error adding student: " + e.getMessage());
            throw new RuntimeException("Error adding student", e);
        }
    }

    @Override
    public Integer GetStudentCount()
    {
        try
        {
            String sql = "SELECT COUNT(*) FROM student";
            return _JdbcTemplate.queryForObject(sql, Integer.class);
        }
        catch (Exception e)
        {
            System.out.println("Error fetching student count: " + e.getMessage());
            throw new RuntimeException("Error fetching student count", e);
        }
    }

    @Override
    public void DeleteStudentByName(String studentName)
    {
        studentName = studentName.toLowerCase();
        String sql = "DELETE FROM student WHERE s_name = ?";
        try
        {
            _JdbcTemplate.update(sql, studentName);
        }
        catch (Exception e)
        {
            System.out.println("Error deleting student: " + e.getMessage());
            throw new RuntimeException("Error deleting student", e);
        }
    }
    
}
