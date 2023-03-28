package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//remember that we add the @Coponent b/c we are making these classnames bean or bean id's
@Component
@Primary
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice backhand volley";
    }
}
