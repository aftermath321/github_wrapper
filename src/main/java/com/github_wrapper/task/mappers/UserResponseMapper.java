package com.github_wrapper.task.mappers;

import com.github_wrapper.task.DTO.response.GithubResponse;
import com.github_wrapper.task.DTO.response.UserResponse;
import com.github_wrapper.task.DTO.response.customObject.Branches;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserResponseMapper {

    public static UserResponse mapToUserResponse(GithubResponse githubResponses, List<Branches> branches) {

        return new UserResponse(githubResponses.name(), githubResponses.owner().login(), branches);

    }
}
