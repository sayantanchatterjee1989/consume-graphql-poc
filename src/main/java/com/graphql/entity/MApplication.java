package com.graphql.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "m_application")
public class MApplication {

	@Id
	@Column(name = "id_pk")
	Long id;

	@Column(name = "application_code")
	String applicationCode;

	@Column(name = "application_name")
	String applicationName;

	@Column(name = "status")
	int status;

	@Column(name = "created_by")
	String createdBy;

	@Column(name = "created_dt")
	LocalDateTime createdDate;

	@Column(name = "repository")
	String repository;

	@Column(name = "repo_owner")
	String repo_owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApplicationCode() {
		return applicationCode;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
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

	public String getRepository() {
		return repository;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	public String getRepo_owner() {
		return repo_owner;
	}

	public void setRepo_owner(String repo_owner) {
		this.repo_owner = repo_owner;
	}

}
