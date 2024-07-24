package com.github_wrapper.task.controller;

import com.github_wrapper.task.DTO.response.ErrorResponse;
import com.github_wrapper.task.exceptions.*;
import com.github_wrapper.task.exceptions.InternalError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllExceptions (Exception exception){
        ErrorResponse errorResponse = new ErrorResponse("INTERNAL_SERVER_ERROR", exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(UnauthorizedAccess.class)
    public ResponseEntity<ErrorResponse> handleUnauthorizedAccessException (Exception exception){
        ErrorResponse errorResponse = new ErrorResponse("Unauthorized Access", exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(ForbiddenAccess.class)
    public ResponseEntity<ErrorResponse> handleForbiddenAccessException (Exception exception){
        ErrorResponse errorResponse = new ErrorResponse("Forbidden Access", exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException (Exception exception){
        ErrorResponse errorResponse = new ErrorResponse("Unauthorized Access", exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ResourcesNotFound.class)
    public ResponseEntity<ErrorResponse> handleResourcesNotFoundException (Exception exception){
        ErrorResponse errorResponse = new ErrorResponse("Unauthorized Access", exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InternalError.class)
    public ResponseEntity<ErrorResponse> handleInternalException (Exception exception){
        ErrorResponse errorResponse = new ErrorResponse("Unauthorized Access", exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }




}
