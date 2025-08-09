package com.yoy.studentmanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yoy.studentmanagement.dto.StudentDto;
import com.yoy.studentmanagement.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentService service ;
	
	public StudentController(StudentService service) {
		super();
		this.service = service;
	}

	@GetMapping
	public List<StudentDto> getStudentDto() {
		return service.getAllStudents() ;
	}
	
	@GetMapping("/{id}")
	public StudentDto getStudentDtobyID(@PathVariable("id") Long studId) {
		return service.getDtoByID(studId) ;
	}
	
	@PostMapping("/addstud")
	public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto stud) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addStudent(stud)) ;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
		service.rmvStud(id) ;
		return ResponseEntity.noContent().build() ;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id , @RequestBody StudentDto studDto) {
		return ResponseEntity.status(HttpStatus.OK).body(service.upWhlStud(id, studDto)) ;
	}
}
