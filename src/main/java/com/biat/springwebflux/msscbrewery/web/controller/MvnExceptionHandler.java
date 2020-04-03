package com.biat.springwebflux.msscbrewery.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MvnExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorsHandle(ConstraintViolationException e) {
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + ":" + constraintViolation.getMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List> handleBinException(BindException ex)
    {
        return new ResponseEntity(ex.getAllErrors(), HttpStatus.BAD_REQUEST);

    }
}
