package com.yoy.crudoperation.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "students")
public class Student 
{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@Column(name = "name")
	private String name ;
	
	@Column(name = "course")
	private String course ;
	
	@Column(name = "marks" , precision = 10 , scale = 2)
	private BigDecimal marks ;
	
	public Student() {
		super();
	}
	
	public Student(String name, String course, BigDecimal marks) {
		super();
		this.name = name;
		this.course = course;
		this.marks = marks;
	}

	public Student(Long id, String name, String course, BigDecimal marks) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.marks = marks;
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

	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}

	public BigDecimal getMarks() {
		return marks;
	}
	public void setMarks(BigDecimal marks) {
		this.marks = marks;
	}
	
	public void display() {
		System.out.println(" ----- STUDENT DETAILS ----- ");
		System.out.println("Roll No :- " + id);
		System.out.println("Name :- " + name);
		System.out.println("Course :- " + course);
		System.out.println("Marks :- " + marks);
	}
}
