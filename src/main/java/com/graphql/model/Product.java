package com.graphql.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Product {

	@JsonProperty("productname")
	private String productName;

	@JsonProperty("productcode")
	private String productCode;

	@JsonProperty("applications")
	private List<Application> applications;

}
