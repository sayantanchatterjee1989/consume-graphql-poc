package com.graphql.service;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ProductGroupServiceImplTestContextConfiguration {

	@Bean
	public ProductGroupService productGroupService() {
		return new ProductGroupServiceImpl();
	}
}
