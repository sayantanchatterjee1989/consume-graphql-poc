package com.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.graphql.entity.MApplication;

@Repository
public interface MApplicationRepository extends JpaRepository<MApplication, Long>{

	@Query("select ma from MApplication ma")
	List<MApplication> fetchAll();
}
