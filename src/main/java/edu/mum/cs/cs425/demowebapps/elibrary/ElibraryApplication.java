package edu.mum.cs.cs425.demowebapps.elibrary;

import edu.mum.cs.cs425.demowebapps.elibrary.Service.StudentService;
import edu.mum.cs.cs425.demowebapps.elibrary.model.Classroom;
import edu.mum.cs.cs425.demowebapps.elibrary.model.Student;
import edu.mum.cs.cs425.demowebapps.elibrary.model.Transcript;
import edu.mum.cs.cs425.demowebapps.elibrary.repository.ClassroomRepository;
import edu.mum.cs.cs425.demowebapps.elibrary.repository.TranscriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ElibraryApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;

	@Autowired
	private TranscriptRepository transcriptRepository;

	@Autowired
	private ClassroomRepository classroomRepository;

	public static void main(String[] args) {
		SpringApplication.run(ElibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Sample Transcript
		Transcript transcript = Transcript.builder()
				.degreeTitle("BS Computer Science")
				.build();
		transcriptRepository.save(transcript);

		// Sample Classroom
		Classroom classroom = Classroom.builder()
				.buildingName("McLaughlin building")
				.roomNumber("M105")
				.build();
		classroomRepository.save(classroom);

		// Sample Student
		Student student = Student.builder()
				.studentNumber("000-61-0001")
				.firstName("Anna")
				.middleName("Lynn")
				.lastName("Smith")
				.cgpa(3.45)
				.dateOfEnrollment(new Date())
				.transcript(transcript)
				.classroom(classroom)
				.build();
		studentService.saveStudent(student);

		System.out.println("Student saved");
	}
}