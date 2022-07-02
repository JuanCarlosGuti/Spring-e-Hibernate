package com.example.demo.controller;


import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    ICourseService courseService;

    @PostMapping()
    public ResponseEntity<?> addCourse(@RequestBody CourseDTO course) {
        courseService.createCourse(course);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Collection<CourseDTO>> listStudents() {
        return ResponseEntity.ok(courseService.getAll());
    }
}
