package com.graphql.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PullRequestDetails {

	@JsonProperty("companies")
	private List<Company> companyDetails;

	public List<Company> getCompanyDetails() {
		return companyDetails;
	}

	public void setCompanyDetails(List<Company> companyDetails) {
		this.companyDetails = companyDetails;
	}

	public static class Company {

		@JsonProperty("companyname")
		private String companyName;

		@JsonProperty("companycode")
		private String companyCode;

		@JsonProperty("productgroups")
		private List<ProductGroup> productgroups;

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getCompanyCode() {
			return companyCode;
		}

		public void setCompanyCode(String companyCode) {
			this.companyCode = companyCode;
		}

		public List<ProductGroup> getProductgroups() {
			return productgroups;
		}

		public void setProductgroups(List<ProductGroup> productgroups) {
			this.productgroups = productgroups;
		}

	}

	public static class ProductGroup {

		@JsonProperty("productgroupname")
		private String productGroupName;

		@JsonProperty("productgroupcode")
		private String productGroupCode;

		@JsonProperty("products")
		private List<Product> products;

		public String getProductGroupName() {
			return productGroupName;
		}

		public void setProductGroupName(String productGroupName) {
			this.productGroupName = productGroupName;
		}

		public String getProductGroupCode() {
			return productGroupCode;
		}

		public void setProductGroupCode(String productGroupCode) {
			this.productGroupCode = productGroupCode;
		}

		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}

	}

	public static class Product {

		@JsonProperty("productname")
		private String productName;

		@JsonProperty("productcode")
		private String productCode;

		@JsonProperty("applications")
		private List<Application> applications;

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getProductCode() {
			return productCode;
		}

		public void setProductCode(String productCode) {
			this.productCode = productCode;
		}

		public List<Application> getApplications() {
			return applications;
		}

		public void setApplications(List<Application> applications) {
			this.applications = applications;
		}

	}

	public static class Application {

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

		public String getApplicationName() {
			return applicationName;
		}

		public void setApplicationName(String applicationName) {
			this.applicationName = applicationName;
		}

		public String getApplicationCode() {
			return applicationCode;
		}

		public void setApplicationCode(String applicationCode) {
			this.applicationCode = applicationCode;
		}

		public String getOwner() {
			return owner;
		}

		public void setOwner(String owner) {
			this.owner = owner;
		}

		public String getRepository() {
			return repository;
		}

		public void setRepository(String repository) {
			this.repository = repository;
		}

		public String getPullrequest() {
			return pullrequest;
		}

		public void setPullrequest(String pullrequest) {
			this.pullrequest = pullrequest;
		}

	}
}
