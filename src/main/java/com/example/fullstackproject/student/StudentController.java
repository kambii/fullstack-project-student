package com.example.fullstackproject.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    @GetMapping
    public List<Student> getAllStudents(){
        List<Student> students = Arrays.asList(
                new Student(
                        1L,"kambal muhindo","java utvecklare","kambi@hotmail.com"
                ),
                new Student(
                        2L,"kambii muhindo","frontend utvecklare","lambi@hotmail.com"
                )

        );
        return students;
    }
}
