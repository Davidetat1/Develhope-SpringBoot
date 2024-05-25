package com.example.esercizio_test_crud.services;

import com.example.esercizio_test_crud.entities.Student;
import com.example.esercizio_test_crud.repo.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        updatedStudent.setId(id);
        return studentRepository.save(updatedStudent);
    }

    public void updateIsWorking(Long id, boolean isWorking) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setWorking(isWorking);
            studentRepository.save(student);
        } else {
            throw new EntityNotFoundException("Student with ID: " + id + " Not Found");
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
