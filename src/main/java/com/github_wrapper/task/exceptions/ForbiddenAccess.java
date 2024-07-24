package com.github_wrapper.task.exceptions;

public class ForbiddenAccess extends RuntimeException{
    public ForbiddenAccess(String message){
        super(message);
    }
}
