package com.example.demo.service;

import com.example.demo.model.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    IStudentService studentService;

    @Test
    public void testGetStudentsWithLastnameLike(){

        StudentDTO student = new StudentDTO();
        student.setLastname("pruebaLastName");
        student.setName("pruebaName");

        studentService.createStudent(student);
        Set<StudentDTO> students = studentService.getStudentsWithLastnameLike("prueba");

        boolean resultado = students.size() > 0;

        assertTrue(resultado);
    }
}