package com.graphql.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.graphql.entity.MApplication;
import com.graphql.model.PullRequestDetails;

public interface ProductGroupApi {

	@RequestMapping(value = "/applications", method = RequestMethod.POST)
	@ResponseBody
	List<MApplication> getApplications();
	
	@RequestMapping(value = "/pullrequest", method = RequestMethod.POST)
	@ResponseBody
	Integer getPullRequests();
	
	@RequestMapping(value = "/pullrequestdetails", method = RequestMethod.POST)
	@ResponseBody
	PullRequestDetails getPullRequestDetails();
	
}
