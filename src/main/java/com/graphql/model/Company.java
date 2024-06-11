package com.graphql.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Company {

	@JsonProperty("companyname")
	private String companyName;

	@JsonProperty("companycode")
	private String companyCode;

	@JsonProperty("productgroups")
	private List<ProductGroup> productgroups;

}
