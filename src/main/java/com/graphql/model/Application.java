package com.graphql.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Application {

	@JsonProperty("applicationname")
	private String applicationName;

	@JsonProperty("applicationcode")
	private String applicationCode;

	@JsonProperty("owner")
	private String owner;

	@JsonProperty("repository")
	private String repository;

	@JsonProperty("pullrequest")
	private String pullrequest;

}
