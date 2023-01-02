package com.example.fullstackproject.student;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "name", updatable = false)
    private Long id;

    @Column(name = "displayName")
    private String displayName;

    @Column(name = "educationTitle")
    private String educationTitle;

    @Column(name = "email")
    private String email;


}
