package com.example.springcoredemo.rest;

import com.example.hello.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;
//    @Autowired
//    public DemoController(Coach theCoach){
//        myCoach = theCoach;
//    }
    @Autowired
    public void setCoach(@Qualifier("swimCoach") Coach theCoach, @Qualifier("swimCoach") Coach anotherCoach){
        System.out.println("In constructor: "+ getClass().getSimpleName());
        myCoach = theCoach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkOut(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String checkScope(){
        return "myCoach == anotherCoach ? " + (myCoach == anotherCoach);
    }

}
