package com.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.graphql.entity.MCompany;

@Repository
public interface MCompanyRepository extends JpaRepository<MCompany, Long> {

	@Query("select mc from MCompany mc")
	List<MCompany> fetchAll();
}
