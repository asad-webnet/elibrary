package edu.mum.cs.cs425.demowebapps.elibrary.controller;

import edu.mum.cs.cs425.demowebapps.elibrary.Repository.StudentRepository;
import edu.mum.cs.cs425.demowebapps.elibrary.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students/list";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/register";
    }

    @PostMapping("/register")
    public String registerStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("student", student);
        return "students/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable("id") Long id, @ModelAttribute Student student) {
        student.setStudentId(id);
        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentRepository.deleteById(id);
        return "redirect:/students";
    }

    // Handler for displaying the student search page
    @GetMapping("/search")
    public String searchStudent(@RequestParam(value = "studentNumber", required = false) String studentNumber, Model model) {
        if (studentNumber != null && !studentNumber.isEmpty()) {
            Student student = studentRepository.findByStudentNumber(studentNumber)
                    .orElse(null);
            model.addAttribute("student", student);
        }
        return "students/search"; // Ensure that students/search.html exists in your templates directory
    }
}
