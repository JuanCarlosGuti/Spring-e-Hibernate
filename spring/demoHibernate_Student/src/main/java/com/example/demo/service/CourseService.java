package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CourseService implements ICourseService{

    @Autowired
    ICourseRepository courseRepository;


    @Autowired
    ObjectMapper mapper;

    @Override
    public void createCourse(CourseDTO course) {
        Course newCourse = mapper.convertValue(course, Course.class);
        courseRepository.save(newCourse);
    }

    @Override
    public Collection<CourseDTO> getAll() {
        List<Course> allCourses = courseRepository.findAll();
        Set<CourseDTO> allCoursesDTO = new HashSet<CourseDTO>();
        for(Course course: allCourses)
            allCoursesDTO.add(mapper.convertValue(course,CourseDTO.class));

        return allCoursesDTO;
    }
}
