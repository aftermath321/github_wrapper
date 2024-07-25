package com.github_wrapper.task.DTO.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github_wrapper.task.DTO.response.customObject.Commit;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BranchesResponse (

        String name,
        Commit commit

){}
