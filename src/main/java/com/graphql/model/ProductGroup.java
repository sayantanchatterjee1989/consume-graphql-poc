package com.graphql.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductGroup {

	@JsonProperty("productgroupname")
	private String productGroupName;

	@JsonProperty("productgroupcode")
	private String productGroupCode;

	@JsonProperty("products")
	private List<Product> products;

}
