package com.github_wrapper.task.exceptions;

public class BadRequest extends RuntimeException {
    public BadRequest(String message){
        super(message);
    }
}
