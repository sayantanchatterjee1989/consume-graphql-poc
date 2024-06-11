package com.graphql.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "m_company")
public class CompanyMaster {

	@Id
	@Column(name = "id_pk")
	Long id;

	@Column(name = "company_code")
	String companyCode;

	@Column(name = "company_name")
	String companyName;

	@Column(name = "status")
	int status;

	@Column(name = "created_by")
	String createdBy;

	@Column(name = "created_dt")
	LocalDateTime createdDate;

	@OneToMany(mappedBy = "companyId")
	private Set<CompanyProdGroupMpg> companyProdGroupMpg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public Set<CompanyProdGroupMpg> getmCmpProdGrpMpg() {
		return companyProdGroupMpg;
	}

	public void setmCmpProdGrpMpg(Set<CompanyProdGroupMpg> companyProdGroupMpg) {
		this.companyProdGroupMpg = companyProdGroupMpg;
	}

}
