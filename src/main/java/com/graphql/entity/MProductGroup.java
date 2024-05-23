package com.graphql.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "m_product_group")
public class MProductGroup {

	@Id
	@Column(name = "id_pk")
	Long id;

	@Column(name = "product_group_code")
	String productGroupCode;

	@Column(name = "product_group_name")
	String productGroupName;

	@Column(name = "status")
	int status;

	@Column(name = "created_by")
	String createdBy;

	@Column(name = "created_dt")
	LocalDateTime createdDate;

	@OneToMany(mappedBy = "productGroupId")
	private Set<MProdGrpProdMpg> mProdGrpProdMpg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductGroupCode() {
		return productGroupCode;
	}

	public void setProductGroupCode(String productGroupCode) {
		this.productGroupCode = productGroupCode;
	}

	public String getProductGroupName() {
		return productGroupName;
	}

	public void setProductGroupName(String productGroupName) {
		this.productGroupName = productGroupName;
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

	public Set<MProdGrpProdMpg> getmProdGrpProdMpg() {
		return mProdGrpProdMpg;
	}

	public void setmProdGrpProdMpg(Set<MProdGrpProdMpg> mProdGrpProdMpg) {
		this.mProdGrpProdMpg = mProdGrpProdMpg;
	}

}
