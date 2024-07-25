package com.github_wrapper.task.util;

import com.github_wrapper.task.DTO.response.BranchesResponse;
import com.github_wrapper.task.DTO.response.GithubResponse;
import com.github_wrapper.task.DTO.response.customObject.Branches;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.github_wrapper.task.util.CreateRestTemplate.API_URL;

@Component
public class GithubApiClient {

    public List<Branches> fetchBranches(String url) {

        ParameterizedTypeReference<List<BranchesResponse>> typeReference = new ParameterizedTypeReference<>() {};
        ResponseEntity<List<BranchesResponse>> response = fetch(url, typeReference);
        List<BranchesResponse> branchResponses = response.getBody();

        List<Branches> branchesList = new ArrayList<>();
        if (branchResponses != null) {
            branchesList = branchResponses.stream()
                    .map(branchesResponse -> new Branches(branchesResponse.name(), branchesResponse.commit().sha()))
                    .toList();
        }
        return branchesList;

    }

    public List<GithubResponse> fetchRepos(String username) {

        String url = API_URL + "users/" + username + "/repos";

        ParameterizedTypeReference<List<GithubResponse>> typeReference = new ParameterizedTypeReference<>() {};
        ResponseEntity<List<GithubResponse>> responseEntity = fetch(url, typeReference);

        List<GithubResponse> githubResponseList = responseEntity.getBody();

        assert githubResponseList != null;
        return githubResponseList.stream()
                .filter(githubResponse -> !githubResponse.fork() && !githubResponse.isPrivate())
                .toList();

    }

    public <T> ResponseEntity<List<T>> fetch(String url, ParameterizedTypeReference<List<T>> typeReference) {

        try {

            CreateRestTemplate createRestTemplate = new CreateRestTemplate();
            RestTemplate restTemplate = createRestTemplate.createRestTemplate();
            HttpEntity<String> entity = createRestTemplate.createHttpEntity();

            return restTemplate.exchange(url, HttpMethod.GET, entity, typeReference);

        } catch (HttpClientErrorException.NotFound | HttpClientErrorException.Unauthorized ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
