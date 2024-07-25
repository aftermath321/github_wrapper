package com.github_wrapper.task.controller;

import com.github_wrapper.task.DTO.response.GithubResponse;
import com.github_wrapper.task.DTO.response.UserResponse;
import com.github_wrapper.task.DTO.response.customObject.Branches;
import com.github_wrapper.task.mappers.UserResponseMapper;
import com.github_wrapper.task.util.GithubApiClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.github_wrapper.task.util.CreateRestTemplate.API_URL;

@RestController
@RequestMapping("/api/v1/github")
public class MainController {


    UserResponseMapper userResponseMapper;
    GithubApiClient githubApiService;

    public MainController(UserResponseMapper userResponseMapper, GithubApiClient githubApiService) {
        this.userResponseMapper = userResponseMapper;
        this.githubApiService = githubApiService;
    }

    @GetMapping("/{username}")
    public List<UserResponse> getRepos(@PathVariable String username) {

        List<UserResponse> userResponseList;

        List<GithubResponse> githubResponses = githubApiService.fetchRepos(username);

        userResponseList = githubResponses.stream().map(githubResponse -> {
            String branches_URL = API_URL + "repos/" + username + "/" + githubResponse.name() + "/branches";
            List<Branches> branchesList = githubApiService.fetchBranches(branches_URL);
            return UserResponseMapper.mapToUserResponse(githubResponse, branchesList);
        }).toList();

        return userResponseList;


    }
}
