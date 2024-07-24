package com.github_wrapper.task.DTO.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github_wrapper.task.DTO.response.customObject.Commit;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BranchesResponse {

    String name;
    Commit commit;

}
