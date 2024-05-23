package com.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.graphql.entity.MProdAppMpg;

@Repository
public interface MProdAppMpgRepository extends JpaRepository<MProdAppMpg, Long> {

	@Query("select mpg from MProdAppMpg mpg")
	List<MProdAppMpg> fetchAll();
}
