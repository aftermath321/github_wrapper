package com.github_wrapper.task.exceptions;

public class UnauthorizedAccess extends RuntimeException {
    public UnauthorizedAccess(String message){
        super(message);
    }
}
