package com.cpms.cpmsbackend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpms.cpmsbackend.model.Student;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TestController {

    private List<Student> students = new ArrayList<>();

    @GetMapping("/test")
    public String test() {
        return "CPMS Backend is running! 🚀";
    }

    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student) {

        students.add(student);

        return student;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }
}