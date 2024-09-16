package edu.mum.cs.cs425.demowebapps.elibrary.controller;

import edu.mum.cs.cs425.demowebapps.elibrary.Service.StudentService;
import edu.mum.cs.cs425.demowebapps.elibrary.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return ResponseEntity.ok("Student saved successfully!");
    }
}
