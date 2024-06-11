package com.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.entity.ApplicationMaster;

@Repository
public interface ApplicationMasterRepository extends JpaRepository<ApplicationMaster, Long> {

}
