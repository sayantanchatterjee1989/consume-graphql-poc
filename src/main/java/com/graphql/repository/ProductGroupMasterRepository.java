package com.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.entity.ProductGroupMaster;

@Repository
public interface ProductGroupMasterRepository extends JpaRepository<ProductGroupMaster, Long> {

}
