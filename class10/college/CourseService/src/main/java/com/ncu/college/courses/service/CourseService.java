package com.ncu.college.courses.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncu.college.courses.dto.CourseDto;
import com.ncu.college.courses.irepository.ICourseRepository;
import com.ncu.college.courses.model.Course;
import org.modelmapper.ModelMapper;

@Service(value = "CourseService")
public class CourseService {

    ICourseRepository _CourseRepository;
    ModelMapper _ModelMapper;

    @Autowired
    public CourseService(ICourseRepository courseRepository, ModelMapper modelMapper) 
    {
        this._CourseRepository = courseRepository;
        this._ModelMapper = modelMapper;
    }

    public CourseDto GetCourseById(String courseId) 
    {
        Course course = _CourseRepository.GetCourseById(courseId);
        return _ModelMapper.map(course, CourseDto.class);
    }

    public String GetCourseNameById(String courseId) 
    {
        return  _CourseRepository.GetCourseNameById(courseId);
    }

    public String GetCourseIdByName(String courseName) 
    {
        String id = _CourseRepository.GetCourseIdByName(courseName);
        if (id != null) {
            return id.toLowerCase();
        }
        return null;
    }

    public CourseDto GetCourseByName(String courseName) 
    {
        Course course = _CourseRepository.GetCourseByName(courseName);
        return _ModelMapper.map(course, CourseDto.class);
    }

    public List<CourseDto> GetAllCourses() 
    {
        List<Course> courses = _CourseRepository.GetAllCourses();
        List<CourseDto> courseDtos = new ArrayList<>();
        for (Course course : courses)
        {
            courseDtos.add(_ModelMapper.map(course, CourseDto.class));
        }

        return courseDtos;
    }

    public CourseDto AddCourse(CourseDto coursedto) 
    {
        Course course = _ModelMapper.map(coursedto, Course.class);
        _CourseRepository.AddCourse(course);

        return coursedto;
    }
}
