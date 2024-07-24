package com.github_wrapper.task.DTO.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github_wrapper.task.DTO.response.customObject.GithubOwner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubResponse {

        private String name;
        @JsonProperty("private")
        private boolean isPrivate;
        GithubOwner owner;

}