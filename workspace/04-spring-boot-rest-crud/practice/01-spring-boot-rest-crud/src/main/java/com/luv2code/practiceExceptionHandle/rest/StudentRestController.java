package com.luv2code.practiceExceptionHandle.rest;

import com.luv2code.practiceExceptionHandle.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> theStudents;
    @PostConstruct
    public void StudentRestController(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Tuan","Dang"));
        theStudents.add(new Student("Thao","Chung"));
        theStudents.add(new Student("Hoa","Nguyen"));
    }
    @GetMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId  ){
        if(studentId<0 || studentId >= theStudents.size()){
            throw new StudentNotFoundException("Student id not found - "+ studentId);
        }
        return theStudents.get(studentId);
    }

}
