package com.yoy.hms.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;

@Entity
@Table(name = "patients")
@ToString
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String name ;
	private LocalDate birthDate ;
	@ToString.Exclude
	private String email ;
	private String gender ;
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", email=" + email + ", gender="
				+ gender + "]";
	}
}
