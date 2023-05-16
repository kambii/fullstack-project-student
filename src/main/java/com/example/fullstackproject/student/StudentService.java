package com.example.fullstackproject.student;

import com.example.fullstackproject.student.exception.BadRequestException;
import com.example.fullstackproject.student.exception.StudentNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
     }

    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public void addStudent(Student student) {
        Boolean existsEmail = studentRepository.selectExistsEmail(student.getEmail());
        if (existsEmail){
            throw new BadRequestException("Email " + student.getEmail() + " Taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if (!studentRepository.existsById(studentId)){
            throw new StudentNotFoundException("Student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    public Student updateStudent(Long id, Student student) {

        Student currentStudent = studentRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        currentStudent.setEmail(student.getEmail());
        currentStudent.setEducationTitle(student.getEducationTitle());
        currentStudent.setDisplayName(student.getDisplayName());

        return studentRepository.save(currentStudent);
    }


   /* @Transactional
    public void updateStudent(Long studentId, String displayName, String email){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student with id " + studentId + "does not exist"));

        if (displayName != null && displayName.length() > 0 &&
                !Objects.equals(student.getDisplayName(), displayName)){
            student.setDisplayName(displayName);
        }

        if (email != null && email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository
                    .findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }*/
}
