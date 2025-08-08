package com.yoy.studentmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yoy.studentmanagement.dto.StudentDto;

@RestController
public class StudentController {

	@GetMapping("/student")
	public StudentDto getStudentDto() {
		return new StudentDto(1L , "Yogendra" , "yoy@gmail.com") ;
	}
}
