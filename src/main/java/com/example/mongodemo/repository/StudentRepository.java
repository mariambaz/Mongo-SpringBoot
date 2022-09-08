package com.example.mongodemo.repository;

import com.example.mongodemo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    Student findByNameEqualsIgnoreCase(String name);
    List<Student> findByPassed(boolean passed);
}
