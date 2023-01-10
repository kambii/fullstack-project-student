package com.example.fullstackproject.student;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    @Column(name = "displayName", nullable = false)
    private String displayName;

    @NotBlank
    @Column(name = "educationTitle", nullable = false)
    private String educationTitle;
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    public Student(String displayName, String educationTitle, String email) {
        this.displayName = displayName;
        this.educationTitle = educationTitle;
        this.email = email;
    }
}
