package com.ncu.college.courses.irepository;

import java.util.List;

import com.ncu.college.courses.model.Course;

public interface ICourseRepository {

    List<Course> GetAllCourses();
    Course GetCourseById(String courseId);
    Course GetCourseByName(String courseName);
    Course AddCourse(Course course);
    Integer GetCourseCount();
    String GetCourseNameById(String courseId);
    String GetCourseIdByName(String courseName);

}
