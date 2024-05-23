package com.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.graphql.entity.MCmpProdGrpMpg;

@Repository
public interface MCmpProdGrpMpgRepository extends JpaRepository<MCmpProdGrpMpg, Long> {

	@Query("select mpg from MCmpProdGrpMpg mpg")
	List<MCmpProdGrpMpg> fetchAll();
}