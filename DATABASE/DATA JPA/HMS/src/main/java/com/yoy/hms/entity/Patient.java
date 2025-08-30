package com.yoy.hms.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.yoy.hms.type.BloodGroup;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
		name = "patients" , 
		uniqueConstraints = { 
				@UniqueConstraint(columnNames = {"naam" , "birthDate"} , name = "unique_person")
		} ,
		indexes = {
				@Index(columnList = "naam, birthDate" , name = "idx_indexes")
		}
)
public class Patient
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@Column (name = "naam" , nullable = false )
	private String name ;
	
	@Column(unique = false, nullable = false)
	private LocalDate birthDate ;
	
	@Column(unique = false, nullable = false)
	private String email ;
	
	@Column(length = 6)
	private String gender ;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt ;
	
	@Enumerated(EnumType.STRING)
	private BloodGroup bloodGroup ;
	
	@OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
	@JoinColumn(name = "patient_insurance_id")
	private Insurance insurance ;
	
	@OneToMany(mappedBy = "patient")
//	@JoinColumn(name = "patient_app_id") // Association is 'mappedBy' another entity and may not specify the '@JoinColumn'
	private List<Appointment> appointments = new ArrayList<>();
	
	public Patient() {
		super();
	}
	public Patient(String name, LocalDate birthDate, String email, String gender, BloodGroup bloodGroup, Insurance insurance, List<Appointment> appointments) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.insurance = insurance;
		this.appointments = appointments ;
	}
	public Patient(Long id, String name, LocalDate birthDate, String email, String gender, LocalDateTime createdAt, BloodGroup bloodGroup, Insurance insurance, List<Appointment> appointments) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
		this.gender = gender;
		this.createdAt = createdAt;
		this.bloodGroup = bloodGroup;
		this.insurance = insurance;
		this.appointments = appointments ;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", email=" + email + ", gender="
				+ gender + ", createdAt=" + createdAt + ", bloodGroup=" + bloodGroup + "]";
	}
}
