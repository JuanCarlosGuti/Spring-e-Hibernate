package com.example.demo.service;

import com.example.demo.model.*;

import java.util.Collection;

public interface ICourseService {

    void createCourse(CourseDTO stu);
    Collection<CourseDTO> getAll();
}
