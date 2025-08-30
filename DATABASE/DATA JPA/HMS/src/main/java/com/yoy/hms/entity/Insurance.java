package com.yoy.hms.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Insurance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, length = 58)
	private String policyName;

	@Column(nullable = false, length = 100)
	private String provider;

	@Column(nullable = false)
	private LocalDate validUntil;

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@OneToOne(mappedBy = "insurance")
	private Patient patient ;
	
	public Insurance() {
		super();
	}
	public Insurance(String policyName, String provider, LocalDate validUntil, Patient patient) {
		super();
		this.policyName = policyName;
		this.provider = provider;
		this.validUntil = validUntil;
		this.patient = patient;
	}
	public Insurance(Long id, String policyName, String provider, LocalDate validUntil, LocalDateTime createdAt, Patient patient) {
		super();
		this.id = id;
		this.policyName = policyName;
		this.provider = provider;
		this.validUntil = validUntil;
		this.createdAt = createdAt;
		this.patient = patient;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public LocalDate getValidUntil() {
		return validUntil;
	}
	public void setValidUntil(LocalDate validUntil) {
		this.validUntil = validUntil;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	@Override
	public String toString() {
		return "Insurance [id=" + id + ", policyName=" + policyName + ", provider=" + provider + ", validUntil="
				+ validUntil + ", createdAt=" + createdAt + "]";
	}

}
