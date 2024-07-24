package com.github_wrapper.task.services;

import com.github_wrapper.task.DTO.response.BranchesResponse;
import com.github_wrapper.task.DTO.response.GithubResponse;
import com.github_wrapper.task.util.CreateRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static com.github_wrapper.task.util.CreateRestTemplate.API_URL;

@Service
public class GithubApiService {

    public Map<String, String> fetchBranches(String url) {

        CreateRestTemplate createRestTemplate = new CreateRestTemplate();
        RestTemplate restTemplate = createRestTemplate.createRestTemplate();
        HttpEntity<String> entity = createRestTemplate.createHttpEntity();

        ResponseEntity<BranchesResponse[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, BranchesResponse[].class);
        BranchesResponse[] branchResponses = response.getBody();

        Map<String, String> branchesMap = new HashMap<>();
        if (branchResponses != null) {
            for (BranchesResponse branchResponse : branchResponses) {
                branchesMap.put(branchResponse.getName(), branchResponse.getCommit().getSha());
            }
        }
        return branchesMap;
    }

    public GithubResponse[] fetchRepos(String username) {

        String url = API_URL + "users/" + username + "/repos";

        CreateRestTemplate createRestTemplate = new CreateRestTemplate();
                RestTemplate restTemplate = createRestTemplate.createRestTemplate();
        HttpEntity<String> entity = createRestTemplate.createHttpEntity();

        ResponseEntity<GithubResponse[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, GithubResponse[].class);

        return responseEntity.getBody();
    }
}
