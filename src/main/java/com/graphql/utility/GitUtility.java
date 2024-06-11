package com.graphql.utility;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.graphql.model.GitResponse;

import reactor.core.publisher.Mono;

@Component
public class GitUtility {

	private final String apiUrl = "https://api.github.com/repos/{owner}/{repository}/pulls?state=all";
	private final WebClient webClient;

	public GitUtility() {
		this.webClient = WebClient.builder().baseUrl(apiUrl).build();
	}

	public int fetchPullRequestDetailsThroughWebClient(String owner, String repository) {
		Mono<List<GitResponse>> apiResponse = webClient.get().uri(uriBuilder -> uriBuilder.build(owner, repository))
				.retrieve().bodyToMono(new ParameterizedTypeReference<List<GitResponse>>() {
				});

		List<GitResponse> response = apiResponse.block();
		return response.size();
	}

	public int fetchPullRequestDetailsThroughRestTemplate(String owner, String repositiry) {
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
