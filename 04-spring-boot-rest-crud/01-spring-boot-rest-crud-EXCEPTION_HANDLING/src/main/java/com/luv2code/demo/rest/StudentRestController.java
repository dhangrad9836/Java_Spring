package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
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

    private List<Student> theStudents;

    //define @PostConstruct to load the students data... only once!
    // we refactored this student data from where it was located below and inside it's own method
    @PostConstruct
    public void loadData(){
        //create the new ArrayList object for use to store the students
        theStudents = new ArrayList<>();

        //adding the students to the Student List Object
        theStudents.add(new Student("Poornima", "Patel"));
        theStudents.add(new Student("Mario", "Rossi"));
        theStudents.add(new Student("Mary", "Smith"));
    }//end loadData() method

    //define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){

//        List<Student> theStudents = new ArrayList<>();
//
//        theStudents.add(new Student("Poornima", "Patel"));
//        theStudents.add(new Student("Mario", "Rossi"));
//        theStudents.add(new Student("Mary", "Smith"));

        //return the list of Students from above method stored
        return theStudents;
    }//end getStudents()

    //define endpoint with mapping for returning a single student and using the {studentId}
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //Just index into the list ... keep it simple for now
        return theStudents.get(studentId);
    }

}//end StudentRestController class
