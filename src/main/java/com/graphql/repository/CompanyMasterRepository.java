package com.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.entity.CompanyMaster;

@Repository
public interface CompanyMasterRepository extends JpaRepository<CompanyMaster, Long> {

}
