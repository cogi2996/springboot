package com.example.thymleafdemohelloworld2.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@RequestParam("studentName") String theName, Model theModel){
        theName = theName.toUpperCase();
        String result = "Hey My Friend from V3!" +theName;
        theModel.addAttribute("message",result );
        return "helloworld";
    }

}
