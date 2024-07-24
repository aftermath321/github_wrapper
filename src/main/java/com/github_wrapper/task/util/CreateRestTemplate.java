package com.github_wrapper.task.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Value;

@Component
public class CreateRestTemplate {

    public static final String API_URL = "https://api.github.com/";

    @Value("${github.api.token}")
    private String githubToken;

    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }

    public HttpEntity<String> createHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json; charset=utf-8");
        headers.set("X-GitHub-Api-Version", "2022-11-28");
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + githubToken);
        return new HttpEntity<>(headers);
    }
}
