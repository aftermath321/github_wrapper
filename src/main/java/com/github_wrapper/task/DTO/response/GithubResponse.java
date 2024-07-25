package com.github_wrapper.task.DTO.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github_wrapper.task.DTO.response.customObject.GithubOwner;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GithubResponse(

        String name,
        @JsonProperty("private") boolean isPrivate,
        GithubOwner owner,
        boolean fork

){}