package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDTO;
import com.example.demo.repository.IStudentRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.rmi.server.ExportException;
import java.util.*;

@Service
public class StudentService implements IStudentService {

    @Autowired
    IStudentRepository studentRepository;


    @Autowired
    ObjectMapper mapper;

    @Override
    public void createStudent(StudentDTO stu) {
        saveStudent(stu);
    }

     @Override
    public StudentDTO readStudent(Long id) throws Exception {
        Optional<Student> found = studentRepository.findById(id);
        if(found.isPresent())
            return mapper.convertValue(found, StudentDTO.class);
        else
            throw new Exception("Student Not Exist");

    }

    @Override
    public void updateStudent(StudentDTO stu) {

        saveStudent(stu);
    }

    private void saveStudent(StudentDTO stu) {
        Student newStudent = mapper.convertValue(stu, Student.class);
        studentRepository.save(newStudent);
    }

    @Override
    public void deleteStudent(Long id) {

        studentRepository.deleteById(id);
    }

    @Override
    public Collection<StudentDTO> getAll() {
        List<Student> allStudents = studentRepository.findAll();
        Set<StudentDTO> allStudentsDTO = new HashSet<StudentDTO>();
        for(Student student: allStudents)
            allStudentsDTO.add(mapper.convertValue(student,StudentDTO.class));

        return allStudentsDTO;
    }

    @Override
    public Set<StudentDTO> getStudentsWithLastnameLike(String lastname) {
        Set<Student> allStudents = studentRepository.getStudentByLastnameLike(lastname);
        Set<StudentDTO> allStudentsDTO = new HashSet<StudentDTO>();
        for(Student student: allStudents)
            allStudentsDTO.add(mapper.convertValue(student,StudentDTO.class));

        return allStudentsDTO;
    }
}
