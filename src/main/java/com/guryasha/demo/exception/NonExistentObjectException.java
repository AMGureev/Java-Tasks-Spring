package com.guryasha.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NonExistentObjectException extends RuntimeException{
    public NonExistentObjectException() {
        super("There is no record with such an id");
    }
}
