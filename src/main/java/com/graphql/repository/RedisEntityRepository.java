package com.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.graphql.entity.RedisEntity;

@Repository
public interface RedisEntityRepository extends CrudRepository<RedisEntity, String>{

}
