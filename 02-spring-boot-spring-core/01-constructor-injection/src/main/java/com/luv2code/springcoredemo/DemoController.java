package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a private field for dependency
    private Coach myCoach;

    //define a constructor for dependency injection
    //Autowired tells Spring to inject a dependency
    @Autowired
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }

    //add GetMapping for endpoints
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
