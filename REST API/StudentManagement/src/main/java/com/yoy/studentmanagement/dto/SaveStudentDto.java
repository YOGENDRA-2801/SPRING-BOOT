package com.yoy.studentmanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SaveStudentDto {
	
	@NotBlank(message = "This is a required field")
	@Size(max = 30 , min = 3 , message = "Size should be between 3 - 30")
	private String name ;
	
	@Email
	@NotBlank(message = "This is a required field")
	private String email ;
	
	public SaveStudentDto() {
		super();
	}
	public SaveStudentDto(String name, String email) {
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
