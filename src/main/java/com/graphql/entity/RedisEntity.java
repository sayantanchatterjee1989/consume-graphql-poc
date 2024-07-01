package com.graphql.entity;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@RedisHash("Companies")
@Data
public class RedisEntity {

	private String id;
	private String value;
}
