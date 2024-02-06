package com.example.thymleafdemohelloworld1.controller;

import com.example.thymleafdemohelloworld1.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String> languages;

    @GetMapping("/showStudentForm")
    public String showForm  (Model theModel){
        Student theStudent = new Student();
        theModel.addAttribute("student",theStudent  );
        theModel.addAttribute("countries",countries);
        theModel.addAttribute("languages", languages);
        System.out.println("hello world");
        return "student-form";
    }
    @RequestMapping(path = "/processStudentForm",method = RequestMethod.POST)
    public String processForm (@ModelAttribute("student") Student theStudent){
        System.out.println("hello" + theStudent.getFirstName());
        return "student-confirmation";
    }


}
