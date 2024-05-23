package com.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.graphql.entity.MProductGroup;

@Repository
public interface MProductGroupRepository extends JpaRepository<MProductGroup, Long> {

	@Query("select mpg from MProductGroup mpg")
	List<MProductGroup> fetchAll();
}
