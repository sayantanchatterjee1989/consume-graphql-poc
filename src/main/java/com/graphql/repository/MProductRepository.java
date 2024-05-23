package com.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.graphql.entity.MProduct;

@Repository
public interface MProductRepository extends JpaRepository<MProduct, Long> {

	@Query("select mp from MProduct mp")
	List<MProduct> fetchAll();
}
