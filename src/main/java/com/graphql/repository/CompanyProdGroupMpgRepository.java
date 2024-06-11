package com.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.entity.CompanyProdGroupMpg;

@Repository
public interface CompanyProdGroupMpgRepository extends JpaRepository<CompanyProdGroupMpg, Long> {

}