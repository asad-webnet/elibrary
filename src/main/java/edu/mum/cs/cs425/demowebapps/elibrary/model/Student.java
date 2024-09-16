package edu.mum.cs.cs425.demowebapps.elibrary.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;

    @Column(nullable = false, unique = true)
    private String studentNumber;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    @Column(nullable = false)
    private String lastName;

    private Double cgpa;

    @Temporal(TemporalType.DATE)
    private Date dateOfEnrollment;

    @ManyToOne
    @JoinColumn(name = "transcript_id")
    private Transcript transcript;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;
}