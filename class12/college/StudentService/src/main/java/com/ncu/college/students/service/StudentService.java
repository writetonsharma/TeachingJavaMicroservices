package com.ncu.college.students.service;
import com.ncu.college.students.dto.Studentdto;
import com.ncu.college.students.irepository.IStudentRepository;
import com.ncu.college.students.model.Student;
import com.ncu.college.students.dto.EnrollmentDto;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Service(value = "StudentService")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class StudentService 
{
    IStudentRepository _StudentRepository;
    ModelMapper _ModelMapper;
    final RestClient _EnrollmentRestClient;
    final RestClient _CourseRestClient;

    final String _CourseCred;
    final String _CourseAuth;
    final String _EnrollmentCred;
    final String _EnrollmentAuth;

    @Autowired
    StudentService(IStudentRepository studentRepository, 
                ModelMapper modelMapper,
                RestClient.Builder restClientBuilder) 
    {
        this._StudentRepository = studentRepository;
        this._ModelMapper = modelMapper;

        _EnrollmentRestClient = 
        restClientBuilder.baseUrl("http://localhost:9002/enrollments").build();
        _CourseRestClient = 
        restClientBuilder.baseUrl("http://localhost:9001/courses").build();

        _CourseCred = "courseservice:courseservice";
        _CourseAuth = "Basic " + Base64.getEncoder().encodeToString(_CourseCred.getBytes(StandardCharsets.UTF_8));
        _EnrollmentCred = "enrollmentservice:enrollmentservice";
        _EnrollmentAuth = "Basic " + Base64.getEncoder().encodeToString(_EnrollmentCred.getBytes(StandardCharsets.UTF_8));

    }

    public List<Studentdto> GetAllStudents() 
    {
        List<Student> students = _StudentRepository.GetAllStudents();
        List<Studentdto> studentDtos = new ArrayList<>();
        for (Student student : students)
        {
            List<EnrollmentDto> enrollments = 
            GetEnrollmentsByRollNumber(student.get_RollNumber());
            if (enrollments == null || enrollments.isEmpty()) 
            {
                continue; // Skip if no enrollments found
            }

            List<String> courses = new ArrayList<>();
            for (EnrollmentDto enrollment : enrollments)
            {
                String courseName = 
                GetCourseNameById(enrollment.get_CourseId());
                courses.add(courseName);
            }
            student.set_Courses(courses);
            Studentdto sdto = _ModelMapper.map(student, Studentdto.class);
            studentDtos.add(sdto);
        }

        return studentDtos;
    }

    public Studentdto GetStudentById(String rollNo)
    {
        Student student = _StudentRepository.GetStudentById(rollNo);
        if(student == null) 
        {
            return null; // or throw an exception
        }
        List<String> courses = new ArrayList<>();
        for(EnrollmentDto enrollment : GetEnrollmentsByRollNumber(rollNo))
        {
            String courseName = GetCourseNameById(enrollment.get_CourseId());
            courses.add(courseName);
        }
        student.set_Courses(courses);
        return _ModelMapper.map(student, Studentdto.class);
    }

    public Studentdto GetStudentByName(String studentName)
    {
        Student student = _StudentRepository.GetStudentByName(studentName);
        if(student == null) 
        {
            return null; // or throw an exception
        }
        List<String> courses = new ArrayList<>();
        for(EnrollmentDto enrollment : GetEnrollmentsByRollNumber(student.get_RollNumber()))
        {
            String courseName = GetCourseNameById(enrollment.get_CourseId());
            courses.add(courseName);
        }
        student.set_Courses(courses);
        return _ModelMapper.map(student, Studentdto.class);
    }

    public String AddStudent(Studentdto studentdto) 
    {
        Student student = _ModelMapper.map(studentdto, Student.class);

        /*
         * student data goes in student table and 
         * courses they are taking goes in enrollment table.
         * Both the transactions should be successful, if not we need to roll back.
         * This cannot be done by @Transactional because if enrollment is successful
         * and student fails, enrollment will not rollback by itself.
         * So we need fine granularity which is done by using programmatic transaction management.
         * We wont do it here and keep it simple for demonstration purposes.
         */

         // Generate student roll number.
        String rollNumber = "S" + (100 + _StudentRepository.GetStudentCount() + 1);
        student.set_RollNumber(rollNumber);

        // Call enrollment service API to add enrollment.
        List<EnrollmentDto> enrollments = new ArrayList<>();
        for(String coursename : student.get_Courses())
        {
            String courseId = GetCourseIdByName(coursename);
            if (courseId == null)
            {
                // if any course not found, bad data, return;
                System.out.println("Course not found: " + coursename);
                return null; // or throw an exception
            }

            EnrollmentDto enrollment = new EnrollmentDto();
            enrollment.set_StudentRollNumber(student.get_RollNumber());
            enrollment.set_CourseId(courseId);
            enrollments.add(enrollment);
        }

        _StudentRepository.AddStudent(student);
        AddEnrollments(enrollments);

        return student.get_RollNumber();
    }

    public void DeleteStudentByName(String studentName)
    {
        Student student = _StudentRepository.GetStudentByName(studentName);
        if (student == null) 
        {
            System.out.println("Student not found: " + studentName);
            return; // or throw an exception
        }

        // Delete enrollments first
        List<EnrollmentDto> enrollments = GetEnrollmentsByRollNumber(student.get_RollNumber());
        if (enrollments != null && !enrollments.isEmpty()) 
        {
            for (EnrollmentDto enrollment : enrollments) 
            {
                DeleteEnrollmentByRollNumber(enrollment.get_StudentRollNumber());
            }
        }

        // Now delete the student
        _StudentRepository.DeleteStudentByName(studentName);
    }

    /*
     * Helper routines;
     */


    public void DeleteEnrollmentByRollNumber(String rollnumber) 
    {
        try
        {
            _EnrollmentRestClient.delete()
                    .uri("/enrollment/{rollnumber}", rollnumber)
                    .header(HttpHeaders.AUTHORIZATION, _EnrollmentAuth)
                    .retrieve()
                    .body(Void.class);
        }
        catch (Exception e)
        {
            System.out.println("Error while deleting enrollment: " + e.getMessage());
        }
    }

    public List<EnrollmentDto> GetEnrollmentsByRollNumber(String rollNumber) 
    {
        try
        {
            return _EnrollmentRestClient.get()
            .uri("/enrollment/rollnumber/{rollNumber}", rollNumber)
            .header(HttpHeaders.AUTHORIZATION, _EnrollmentAuth)
            .retrieve()
            .body(new ParameterizedTypeReference<List<EnrollmentDto>>() {});
        }
        catch (Exception e)
        {
            System.out.println("Error while fetching enrollments: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public void AddEnrollments(List<EnrollmentDto> enrollmentsDtos)
    {
        try
        {
            _EnrollmentRestClient.post()
                    .uri("/enrollment")
                    .header(HttpHeaders.AUTHORIZATION, _EnrollmentAuth)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(enrollmentsDtos)
                    .retrieve()
                    .body(Void.class);
        }
        catch (Exception e)
        {
            System.out.println("Error while adding enrollment: " + e.getMessage());
        }
    }

    String GetCourseNameById(String courseId) 
    {
        try
        {
            return _CourseRestClient.get()            
                        .uri("/course/coursename/{courseId}", courseId)
                        .header(HttpHeaders.AUTHORIZATION, _CourseAuth)
                        .retrieve()
                        .body(String.class);
        }
        catch (Exception e)
        {
            System.out.println("Error while fetching course name: " + e.getMessage());
            return null; // or throw a custom exception
        }
    }

    String GetCourseIdByName(String courseName) 
    {
        try
        {
            return _CourseRestClient.get()
                        .uri("/course/courseid/{coursename}", courseName)
                        .header(HttpHeaders.AUTHORIZATION, _CourseAuth)
                        .retrieve()
                        .body(String.class);
        }
        catch (Exception e)
        {
            System.out.println("Error while fetching course ID: " + e.getMessage());
            return null; // or throw a custom exception
        }
    }

}
