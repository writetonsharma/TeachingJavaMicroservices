package com.ncu.college.enrollments.irepository;

import java.util.List;

import com.ncu.college.enrollments.model.Enrollment;

public interface IEnrollmentRepository 
{
    List<Enrollment> GetAllEnrollments();
    List<Enrollment> GetEnrollmentByRollNumber(String rollNumber);
    List<Enrollment> GetEnrollmentByCourseId(String courseId);
    void AddEnrollment(Enrollment enrollment);
    void DeleteEnrollmentByRollNumber(String rollNumber);
}