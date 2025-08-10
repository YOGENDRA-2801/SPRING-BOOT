package com.yoy.studentmanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class PartialUpdateStudentDto {
	
	@Size(max = 30 , min = 3 , message = "Size should be between 3 - 30")
	private String name ;
	
	@Email
	private String email ;
	
	public PartialUpdateStudentDto() {
		super();
	}
	public PartialUpdateStudentDto(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
