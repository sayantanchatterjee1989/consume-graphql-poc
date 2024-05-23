package com.graphql.utility;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.graphql.model.GitResponse;

@Component
public class GitUtility {

	public int fetchPullRequestDetails(String owner, String repositiry) {
		int response = 0;
		String url = "https://api.github.com/repos/" + owner + "/" + repositiry + "/pulls?state=all";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<GitResponse>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<GitResponse>>() {
				});
		response = responseEntity.getBody().size();
		return response;
	}
}
