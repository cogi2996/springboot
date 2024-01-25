package com.example.demoRest.rest;

import com.example.demoRest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {
    List<Student> theStudents;
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Tuan","Dang"));
        theStudents.add(new Student("Thao","Chung"));
        theStudents.add(new Student("Hoa","Nguyen"));
    }

    @GetMapping("/students")
    public List<Student> getTheStudents(){return theStudents;}

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if(studentId <0 || studentId >= theStudents.size()){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (StudentNotFoundException exe){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exe.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

    }





}
