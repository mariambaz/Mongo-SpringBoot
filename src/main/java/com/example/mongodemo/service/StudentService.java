package com.example.mongodemo.service;

import com.example.mongodemo.model.Student;
import com.example.mongodemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findByName(String name) {
        return studentRepository.findByNameEqualsIgnoreCase(name);
    }

    public List<Student> findPassed() {
        return studentRepository.findByPassed(true);
    }
}
