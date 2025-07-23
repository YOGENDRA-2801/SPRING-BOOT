package com.yoy.corecrud.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "department")
	private String department;
	@Column(name = "role")
	private String role;
	@Column(name = "salary" , precision = 10 , scale = 2)
	private BigDecimal salary;

	public Employee() {
		super();
	}

	public Employee(String name, String department, String role, BigDecimal salary) {
		super();
		this.name = name;
		this.department = department;
		this.role = role;
		this.salary = salary;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public void display() {
		System.out.println(" ----- EMPLOYEE DETAIL ----- ");
		System.out.println("ID : " + id);
		System.out.println("NAME : " + name);
		System.out.println("DEPARTMENT : " + department);
		System.out.println("ROLE : " + role);
		System.out.println("SALARY : " + salary);
	}
}