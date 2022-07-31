package com.example.student.exception_advice;


import com.example.student.custom_exception.ResourceNotFoundCustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyExceptionHandlerAdvice {
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(ResourceNotFoundCustomException.class)
    public String handleResourceNotFoundCustomException(ResourceNotFoundCustomException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleResourceNotFoundCustomException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(x -> errors.put(x.getField(), x.getDefaultMessage()));
        return errors;
    }
}
