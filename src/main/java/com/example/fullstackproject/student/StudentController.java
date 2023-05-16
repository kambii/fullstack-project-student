package com.example.fullstackproject.student;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
      return studentService.getAllStudents();
    }

    @GetMapping("{studentId}")
    public Student getStudent(@PathVariable("studentId") Long id){
        return studentService.getStudent(id);
    }

    @PostMapping
    public void addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public ResponseEntity updateStudent(@PathVariable("studentId") Long id,@RequestBody Student student){
        Student updatedStudent = studentService.updateStudent(id,student);
        return ResponseEntity.ok(updatedStudent);
    }

   /* @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String displayName,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, displayName, email);
    }*/
}
