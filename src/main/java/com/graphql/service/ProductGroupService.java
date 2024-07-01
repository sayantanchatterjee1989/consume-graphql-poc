package com.graphql.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.graphql.model.PullRequestDetails;

public interface ProductGroupService {

	PullRequestDetails fetchPullRequestDetails() throws JsonProcessingException;
}
