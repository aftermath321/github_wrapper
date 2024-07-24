package com.github_wrapper.task.mappers;

import com.github_wrapper.task.DTO.response.GithubResponse;
import com.github_wrapper.task.DTO.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class UserResponseMapper {

    public static UserResponse mapToUserResponse(GithubResponse githubResponses, Map<String, String> branchesMap) {


        return new UserResponse(githubResponses.getName(), githubResponses.getOwner().getLogin(), branchesMap);
    }
}
