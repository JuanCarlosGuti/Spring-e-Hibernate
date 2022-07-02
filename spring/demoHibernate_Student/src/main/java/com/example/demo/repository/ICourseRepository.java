package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.*;

public interface ICourseRepository extends JpaRepository<Course, Long> {

}
