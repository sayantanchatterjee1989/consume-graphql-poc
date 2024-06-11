package com.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.entity.ProductApplicationMpg;

@Repository
public interface ProductApplicationMpgRepository extends JpaRepository<ProductApplicationMpg, Long> {

}
