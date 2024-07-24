package com.github_wrapper.task.DTO.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@ToString
@Setter
@Getter
public class UserResponse {

    String repoName;
    String repoOwner;
    Map<String, String> branches;

}
