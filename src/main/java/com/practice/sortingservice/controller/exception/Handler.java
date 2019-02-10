package com.practice.sortingservice.controller.exception;

import com.practice.sortingservice.exception.NoSuchKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.ResponseEntity.badRequest;

@ControllerAdvice
public class Handler {

    @ExceptionHandler(NoSuchKeyException.class)
    protected ResponseEntity<String> handleNoSuchKey(NoSuchKeyException e) {
        return badRequest().body(e.getMessage());
    }
}
