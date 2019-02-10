package com.practice.sortingservice.controller.exception;

import com.practice.sortingservice.exception.NoSuchKeyException;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.ResponseEntity.badRequest;

@ControllerAdvice
public class Handler {

    @ExceptionHandler(NoSuchKeyException.class)
    public HttpEntity<String> handleNoSuchKey(NoSuchKeyException e) {
        return badRequest().body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HttpEntity<String> handleInvalidMethodArgument(MethodArgumentNotValidException e) {
        return badRequest().body(e.getMessage());
    }
}
