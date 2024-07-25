package com.github_wrapper.task.DTO.response.customObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GithubOwner (

        String login

){}