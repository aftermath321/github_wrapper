package com.github_wrapper.task.DTO.response;

import com.github_wrapper.task.DTO.response.customObject.Branches;

import java.util.List;

public record UserResponse (

        String repoName,
        String repoOwner,
        List<Branches> branches

) {}
