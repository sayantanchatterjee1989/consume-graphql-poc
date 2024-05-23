package com.graphql.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GitResponse {

	@JsonProperty("url")
	private String url;

	@JsonProperty("id")
	private String id;

}
