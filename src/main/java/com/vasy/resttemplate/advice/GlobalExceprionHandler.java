package com.vasy.resttemplate.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vasy.resttemplate.exception.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceprionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public String EntityNotFoundExceptionHandler(EntityNotFoundException exception) {
        return exception.getMessage();
    }
}
