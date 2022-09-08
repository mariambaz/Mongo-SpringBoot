package com.example.mongodemo.controller;

import com.example.mongodemo.model.Student;
import com.example.mongodemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(method = RequestMethod.GET, value = "/getStudents")
    public List<Student> findAllStudents() {
        return studentService.getStudents();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getStudent/{name}")
    public Student addStudent(@PathVariable String name) {
        return studentService.findByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getStudents/passed")
    public List<Student> findPassed() {
        return studentService.findPassed();
    }

}
