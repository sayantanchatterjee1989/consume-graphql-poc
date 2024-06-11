package com.graphql.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.graphql.entity.ApplicationMaster;
import com.graphql.model.PullRequestDetails;

public interface ProductGroupApi {

	@RequestMapping(value = "/pullrequestdetails", method = RequestMethod.POST)
	@ResponseBody
	PullRequestDetails getPullRequestDetails();
	
}
