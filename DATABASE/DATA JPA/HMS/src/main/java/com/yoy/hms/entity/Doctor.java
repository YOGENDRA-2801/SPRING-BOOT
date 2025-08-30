package com.yoy.hms.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Doctor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@Column(nullable = false , length = 100)
	private String name ;
	
	@Column(nullable = false, length = 100)
	private String specialization ;
	
	@Column(nullable = false, unique = true, length = 100)
	private String email ;
	
	@ManyToMany(mappedBy = "doctors")
    private Set<Department> departments = new HashSet<>() ;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments = new ArrayList<>();
	
	public Doctor() {
		super();
	}
	public Doctor(String name, String specialization, String email, Set<Department> departments, List<Appointment> appointments) {
		super();
		this.name = name;
		this.specialization = specialization;
		this.email = email;
		this.departments = departments;
		this.appointments = appointments;
	}
	public Doctor(Long id, String name, String specialization, String email, Set<Department> departments, List<Appointment> appointments) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.email = email;
		this.departments = departments;
		this.appointments = appointments;
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
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specialization=" + specialization + ", email=" + email + "]";
	}
	
}
