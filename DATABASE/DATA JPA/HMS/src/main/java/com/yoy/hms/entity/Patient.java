package com.yoy.hms.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
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
	private LocalDate birthDate ;
	
	@Column(unique = false, nullable = false)
	private String email ;
	
	@Column(length = 6)
	private String gender ;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt ;
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", email=" + email + ", gender="
				+ gender + ", createdAt=" + createdAt + "]";
	}
}
