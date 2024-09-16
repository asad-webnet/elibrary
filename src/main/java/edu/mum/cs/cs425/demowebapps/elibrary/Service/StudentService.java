package edu.mum.cs.cs425.demowebapps.elibrary.Service;

import edu.mum.cs.cs425.demowebapps.elibrary.model.Student;
import edu.mum.cs.cs425.demowebapps.elibrary.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
