package com.github_wrapper.task.controller;

import com.github_wrapper.task.DTO.response.GithubResponse;
import com.github_wrapper.task.DTO.response.UserResponse;
import com.github_wrapper.task.exceptions.BadRequest;
import com.github_wrapper.task.exceptions.ForbiddenAccess;
import com.github_wrapper.task.exceptions.InternalError;
import com.github_wrapper.task.exceptions.UnauthorizedAccess;
import com.github_wrapper.task.mappers.UserResponseMapper;
import com.github_wrapper.task.services.GithubApiService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.github_wrapper.task.util.CreateRestTemplate.API_URL;

@RestController
@RequestMapping("/api/v1/github")
public class MainController {


    UserResponseMapper userResponseMapper;
    GithubApiService githubApiService;

    public MainController(UserResponseMapper userResponseMapper, GithubApiService githubApiService) {
        this.userResponseMapper = userResponseMapper;
        this.githubApiService = githubApiService;
    }

    @GetMapping("/{username}")
    public List<UserResponse> getRepos(@PathVariable String username) {

        List<UserResponse> userResponseList = new ArrayList<>();
        try {
            GithubResponse[] githubResponses = githubApiService.fetchRepos(username);

            for (GithubResponse githubResponse : githubResponses) {
                if (!githubResponse.isPrivate()) {
                    Map<String, String> branchesMap;

                    String branches_URL = API_URL + "repos/" + username + "/" + githubResponse.getName() + "/branches";

                    branchesMap = githubApiService.fetchBranches(branches_URL);
                    UserResponse userResponse = UserResponseMapper.mapToUserResponse(githubResponse, branchesMap);
                    userResponseList.add(userResponse);
                }

            }
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
                throw new UnauthorizedAccess("Unauthorized access to GitHub API.");
            } else if (e.getStatusCode() == HttpStatus.FORBIDDEN) {
                throw new ForbiddenAccess("Access to GitHub API is forbidden.");
            } else if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new BadRequest("Bad request to GitHub API.");
            } else if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
                throw new InternalError("Internal server error on GitHub API.");
            }else if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new InternalError("Resources not found.");
            }
            throw e;
        }
        return userResponseList;

    }
}
