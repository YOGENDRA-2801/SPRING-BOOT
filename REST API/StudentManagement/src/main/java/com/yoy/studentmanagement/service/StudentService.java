package com.yoy.studentmanagement.service;

import java.util.List;
import java.util.Map;

import com.yoy.studentmanagement.dto.StudentDto;
import com.yoy.studentmanagement.dto.SaveStudentDto;

public interface StudentService {
	public List<StudentDto> getAllStudents() ;
	public StudentDto getDtoByID(Long id) ;
	public StudentDto addStudent(SaveStudentDto stud) ;
	public void rmvStud(Long id) ;
	public StudentDto upWhlStud(Long id , SaveStudentDto updStudDto) ;
	public StudentDto patchUpdate(Long id, Map<String, Object> update) ;
}