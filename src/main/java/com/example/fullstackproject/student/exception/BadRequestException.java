package com.example.fullstackproject.student.exception;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String msg){
        super(msg);
    }
}
