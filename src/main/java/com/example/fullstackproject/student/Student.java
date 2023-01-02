package com.example.fullstackproject.student;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue( generator = "student_sequence",strategy = GenerationType.SEQUENCE)

    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "displayName")
    private String displayName;

    @Column(name = "educationTitle")
    private String educationTitle;

    @Column(name = "email")
    private String email;

    public Student(String displayName, String educationTitle, String email) {
        this.displayName = displayName;
        this.educationTitle = educationTitle;
        this.email = email;
    }
}
