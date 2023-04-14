package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        //check the studentId against the size of the list
        if((studentId >= theStudents.size()) || (studentId < 0)){
            //this is our custom exception class StudentNotFoundException we made
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }

    //ALL THE CODE COMMENTED BELOW WAS REFACTORED TO CLASS StudentRestExceptionHandler inside @ControllerAdvice for global exception handling

//    //Add an exception handler using @ExceptionHandler...by using the @ExceptionHandler annotation it tells this method that this method handles exceptions
//    @ExceptionHandler
//    //note that ResponseEntity is from the spring framework
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
//
//        // create a new StudentErrorResponse
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        //set fields from StudentErrorResponse class
//        error.setStatus(HttpStatus.NOT_FOUND.value());  //note that HttpStatus.NOT_FOUND.value() is from spring framework
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        // return a new ResponseEntity....note (error, HttpStatus.NOT_FOUND) ..error is the body of the response and HttpStatus.NOT_FOUND is the acutal code of the response
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler
//    //note this exception is diffrerent from the custom one above why? B/C this is to catch anything that might be placed other than a number ie:
//    //if we enter xsksfs for the student id it will return a 404 bad request and doing so properly
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
//        // create a new StudentErrorResponse
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        //set fields from StudentErrorResponse class....NOTE here we changed to BAD_REQUEST to handle anything other than an int for student id
//        error.setStatus(HttpStatus.BAD_REQUEST.value());  //note that HttpStatus.NOT_FOUND.value() is from spring framework
//        //error.setMessage(exc.getMessage());
//        error.setMessage("Not an integer");     //you can enter any custom message here if you want to
//        error.setTimeStamp(System.currentTimeMillis());
//
//        // return a new ResponseEntity....note (error, HttpStatus.NOT_FOUND) ..error is the body of the response and HttpStatus.NOT_FOUND is the acutal code of the response
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//
//    }

}//end StudentRestController class
