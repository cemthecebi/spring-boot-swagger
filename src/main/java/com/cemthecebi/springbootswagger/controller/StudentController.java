package com.cemthecebi.springbootswagger.controller;


import com.cemthecebi.springbootswagger.entity.Student;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@Api(value = "Student Management System")
public class StudentController {

    private static final List<Student> STUDENT_LIST = Arrays.asList(
            new Student(1L, "Bruce Wayne"),
            new Student(2L, "Oswald Cobblepot"),
            new Student(3L, "Alfred Pennyworth")
    );

    @ApiOperation("Get student by Id")
    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable("studentId") Long studentId) {
        return STUDENT_LIST.stream()
                .filter(student -> studentId.equals(student.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student" + studentId + "does not exists"));
    }
}
