package com.luv2code.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
//note that @ControllerAdvice makes this as a global exception so we will remove the code from @ExceptionHandler and
//place it inside StudentRestExceptionHandler class
public class StudentRestExceptionHandler {

    //add exception handling code here
    //Add an exception handler using @ExceptionHandler...by using the @ExceptionHandler annotation it tells this method that this method handles exceptions
    @ExceptionHandler
    //note that ResponseEntity is from the spring framework
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        // create a new StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        //set fields from StudentErrorResponse class
        error.setStatus(HttpStatus.NOT_FOUND.value());  //note that HttpStatus.NOT_FOUND.value() is from spring framework
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return a new ResponseEntity....note (error, HttpStatus.NOT_FOUND) ..error is the body of the response and HttpStatus.NOT_FOUND is the acutal code of the response
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    //note this exception is diffrerent from the custom one above why? B/C this is to catch anything that might be placed other than a number ie:
    //if we enter xsksfs for the student id it will return a 404 bad request and doing so properly
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        // create a new StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        //set fields from StudentErrorResponse class....NOTE here we changed to BAD_REQUEST to handle anything other than an int for student id
        error.setStatus(HttpStatus.BAD_REQUEST.value());  //note that HttpStatus.NOT_FOUND.value() is from spring framework
        //error.setMessage(exc.getMessage());
        error.setMessage("Not an integer");     //you can enter any custom message here if you want to
        error.setTimeStamp(System.currentTimeMillis());

        // return a new ResponseEntity....note (error, HttpStatus.NOT_FOUND) ..error is the body of the response and HttpStatus.NOT_FOUND is the acutal code of the response
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
}
