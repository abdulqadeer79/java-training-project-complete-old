package com.example.student.custom_exception;

public class ResourceNotFoundCustomException extends Exception{
    public ResourceNotFoundCustomException(String message) {
        super(message);
    }
}
