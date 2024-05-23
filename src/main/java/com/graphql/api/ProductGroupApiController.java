package com.graphql.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.entity.MApplication;
import com.graphql.model.PullRequestDetails;
import com.graphql.service.ProductGroupService;

@RestController
public class ProductGroupApiController implements ProductGroupApi {
	
	@Autowired
	ProductGroupService productGroupService;

	@Override
	public List<MApplication> getApplications() {
		List<MApplication>  response = productGroupService.fetchApplications();
		System.out.println(response);
		return response;
	}

	@Override
	public Integer getPullRequests() {
		return productGroupService.fetchPullRequest();
	}

	@Override
	public PullRequestDetails getPullRequestDetails() {
		return productGroupService.fetchPullRequestDetails();
	}

}
