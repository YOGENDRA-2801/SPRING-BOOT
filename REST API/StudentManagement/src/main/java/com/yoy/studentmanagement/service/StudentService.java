package com.yoy.studentmanagement.service;

import java.util.List;

import com.yoy.studentmanagement.dto.StudentDto;

public interface StudentService {
	public List<StudentDto> getAllStudents() ;
	public StudentDto getDtoByID(Long id) ;
	public StudentDto addStudent(StudentDto stud) ;
	public void rmvStud(Long id) ;
	public StudentDto upWhlStud(Long id , StudentDto updStud) ;
}