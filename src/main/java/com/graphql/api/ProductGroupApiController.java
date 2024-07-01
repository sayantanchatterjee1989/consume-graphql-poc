package com.graphql.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.graphql.model.PullRequestDetails;
import com.graphql.service.ProductGroupService;

@RestController
public class ProductGroupApiController implements ProductGroupApi {

	@Autowired
	ProductGroupService productGroupService;

	@Override
	public PullRequestDetails getPullRequestDetails() throws JsonProcessingException {
		return productGroupService.fetchPullRequestDetails();
	}

}
