package com.graphql.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "m_product_application_mpg")
public class MProdAppMpg {

	@Id
	@Column(name = "id_pk")
	Long id;

	@ManyToOne
	@JoinColumn(name = "application_id", nullable = false)
	MApplication applicationId;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	MProduct productId;

	@Column(name = "status")
	int status;

	@Column(name = "created_by")
	String createdBy;

	@Column(name = "created_dt")
	LocalDateTime createdDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MApplication getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(MApplication applicationId) {
		this.applicationId = applicationId;
	}

	public MProduct getProductId() {
		return productId;
	}

	public void setProductId(MProduct productId) {
		this.productId = productId;
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

}
