package com.example.entitytodto.EntityToDTOConversion.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class StudentAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PropertyNotFoundException.class)
    public ResponseEntity<Student> handleException(PropertyNotFoundException p){
        return new ResponseEntity(p.getMessage(),HttpStatus.NOT_FOUND);
    }
}
