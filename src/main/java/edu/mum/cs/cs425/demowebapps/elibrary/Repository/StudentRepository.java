package edu.mum.cs.cs425.demowebapps.elibrary.Repository;

import edu.mum.cs.cs425.demowebapps.elibrary.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByStudentNumber(String studentNumber);
}
