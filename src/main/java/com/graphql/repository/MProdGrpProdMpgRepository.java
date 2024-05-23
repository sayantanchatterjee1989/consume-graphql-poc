package com.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.graphql.entity.MProdGrpProdMpg;

@Repository
public interface MProdGrpProdMpgRepository extends JpaRepository<MProdGrpProdMpg, Long> {

	@Query("select mpg from MProdGrpProdMpg mpg")
	List<MProdGrpProdMpg> fetchAll();
}
