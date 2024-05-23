package com.graphql;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.graphql.entity.MApplication;
import com.graphql.service.ProductGroupService;

@SpringBootApplication
@ComponentScan(basePackages = "com.graphql")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}