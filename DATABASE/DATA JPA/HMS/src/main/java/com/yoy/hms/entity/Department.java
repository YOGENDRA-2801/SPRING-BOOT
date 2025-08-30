package com.yoy.hms.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Department 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @OneToOne
    private Doctor headDoctor;

    @ManyToMany
    @JoinTable(
            name = "my_dpt_doctors",
            joinColumns = @JoinColumn(name = "dpt_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private Set<Doctor> doctors = new HashSet<>() ;

	public Department() {
		super();
	}
	public Department(String name, Doctor headDoctor, Set<Doctor> doctors) {
		super();
		this.name = name;
		this.headDoctor = headDoctor;
		this.doctors = doctors;
	}
	public Department(Long id, String name, Doctor headDoctor, Set<Doctor> doctors) {
		super();
		this.id = id;
		this.name = name;
		this.headDoctor = headDoctor;
		this.doctors = doctors;
	}
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}
