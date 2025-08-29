package com.ncu.college.enrollments.service;
import com.ncu.college.enrollments.dto.Enrollmentdto;
import com.ncu.college.enrollments.irepository.IEnrollmentRepository;
import com.ncu.college.enrollments.model.Enrollment;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service(value = "EnrollmentService")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class EnrollmentService
{
    IEnrollmentRepository _EnrollmentRepository;
    ModelMapper _ModelMapper;


    @Autowired
    public EnrollmentService(IEnrollmentRepository enrollmentRepository, ModelMapper modelMapper) 
    {
        this._EnrollmentRepository = enrollmentRepository;
        this._ModelMapper = modelMapper;
    }

    public List<Enrollmentdto> GetAllEnrollments() 
    {
        List<Enrollment> enrollments = _EnrollmentRepository.GetAllEnrollments();
        
        List<Enrollmentdto> enrollmentDtos = new ArrayList<>();
        for (Enrollment enrollment : enrollments)
        {
            enrollmentDtos.add(_ModelMapper.map(enrollment, Enrollmentdto.class));
        }

        return enrollmentDtos;
    }

    public List<Enrollmentdto> GetEnrollmentByRollNumber(String rollNumber) 
    {
        List<Enrollment> enrollments = _EnrollmentRepository.GetEnrollmentByRollNumber(rollNumber);
        if (enrollments.isEmpty()) {
            return null;
        }

        List<Enrollmentdto> enrollmentDtos = new ArrayList<>();
        for (Enrollment enrollment : enrollments)
        {
            enrollmentDtos.add(_ModelMapper.map(enrollment, Enrollmentdto.class));
        }

        return enrollmentDtos;
    }

    public List<Enrollmentdto> GetEnrollmentByCourseId(String courseId) 
    {
        List<Enrollment> enrollments = _EnrollmentRepository.GetEnrollmentByCourseId(courseId);
        List<Enrollmentdto> enrollmentDtos = new ArrayList<>();
        for (Enrollment enrollment : enrollments)
        {
            enrollmentDtos.add(_ModelMapper.map(enrollment, Enrollmentdto.class));
        }
        return enrollmentDtos;
    }

    public void AddEnrollment(List<Enrollmentdto> enrollmentdto) 
    {
        for (Enrollmentdto dto : enrollmentdto) 
        {
            _EnrollmentRepository.AddEnrollment(_ModelMapper.map(dto,
             Enrollment.class));
        }
    }

    public void DeleteEnrollmentByRollNumber(String rollNumber) 
    {
        _EnrollmentRepository.DeleteEnrollmentByRollNumber(rollNumber);
    }
}
