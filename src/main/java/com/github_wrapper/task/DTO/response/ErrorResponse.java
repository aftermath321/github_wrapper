package com.github_wrapper.task.DTO.response;

import org.springframework.http.HttpStatus;

public record ErrorResponse(

        HttpStatus code,
        String message

) {}
