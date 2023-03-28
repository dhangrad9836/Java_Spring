package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a private field for dependency
    private Coach myCoach;

    //using @Qualifier to specify which bean ID or class we want to implement and this default Singleton scope so
    //all beans are reference to the same bean
   @Autowired
   public DemoController(@Qualifier("cricketCoach") Coach theCoach){
       System.out.println("In constructor: " + getClass().getSimpleName());
       myCoach = theCoach;
   }

    //add GetMapping for endpoints
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){

       return myCoach.getDailyWorkout();
    }



}
