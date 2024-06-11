package com.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.entity.ProductGroupProductMpg;

@Repository
public interface ProductGroupProductMpgRepository extends JpaRepository<ProductGroupProductMpg, Long> {
}
