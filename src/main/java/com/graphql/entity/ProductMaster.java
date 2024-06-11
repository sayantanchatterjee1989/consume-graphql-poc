package com.graphql.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "m_product")
public class ProductMaster {

	@Id
	@Column(name = "id_pk")
	Long id;

	@Column(name = "product_code")
	String productCode;

	@Column(name = "product_name")
	String productName;

	@Column(name = "status")
	int status;

	@Column(name = "created_by")
	String createdBy;

	@Column(name = "created_dt")
	LocalDateTime createdDate;

	@OneToMany(mappedBy = "productId")
	private Set<ProductApplicationMpg> productApplicationMpg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Set<ProductApplicationMpg> getmProdAppMpg() {
		return productApplicationMpg;
	}

	public void setmProdAppMpg(Set<ProductApplicationMpg> productApplicationMpg) {
		this.productApplicationMpg = productApplicationMpg;
	}

}
