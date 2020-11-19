package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Jozko Mrkvicka"),
            new Student(2, "Ivan Ivanov"),
            new Student(3, "Jone Doe")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") int studentId) {
        Student student = null;
        for (Student s : STUDENTS) {
            if (s.getStudentId() == studentId) {
                student = s;
                break;
            }
        }
        if (student == null) {
            throw new IllegalStateException("Student " + studentId + " neexistuje");
        }
        return student;
    }
}