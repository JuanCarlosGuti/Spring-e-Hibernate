package com.example.demo.controller;

import com.example.demo.model.StudentDTO;
import com.example.demo.service.IStudentService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping()
    public ResponseEntity<?> addStudent(@RequestBody StudentDTO stu) {
        studentService.createStudent(stu);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public StudentDTO getStudent(@PathVariable Long id) throws Exception {
       return studentService.readStudent(id);
    }

    @PutMapping()
    public ResponseEntity<?> modifyStudent(@RequestBody StudentDTO stu) {
        studentService.updateStudent(stu);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeStudent(@PathVariable Long id) {

        ResponseEntity<String> response = null;
        studentService.deleteStudent(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

    @GetMapping("/list")
    public Collection<StudentDTO> listStudents() {
        return studentService.getAll();
    }

    @GetMapping("/getLastnameLike")
    public Set<StudentDTO> listStudentsWithLastnameLike(@RequestParam String lastname) {
        return studentService.getStudentsWithLastnameLike(lastname);
    }


}
