package com.yoy.studentmanagement.service.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.yoy.studentmanagement.dto.StudentDto;
import com.yoy.studentmanagement.entity.Student;
import com.yoy.studentmanagement.repository.StudentRepository;
import com.yoy.studentmanagement.service.StudentService;

@Service
public class StudSrvcImpl implements StudentService
{
	private final StudentRepository repository ;
	private final ModelMapper modelMapper ;

	public StudSrvcImpl(StudentRepository repository, ModelMapper modelMapper) {
		super();
		this.repository = repository;
		this.modelMapper = modelMapper ;
	}

	@Override
	public List<StudentDto> getAllStudents() {
		List<Student> allStudents = repository.findAll() ;
		return allStudents
				.stream()
	            .map(student -> new StudentDto(
	                    student.getId(),
	                    student.getName(),
	                    student.getEmail()
	            ))
	            .toList();
	}

	@Override
	public StudentDto getDtoByID(Long id) {
		Student stud = repository.findById(id).get() ;
		return modelMapper.map(stud, StudentDto.class) ;
	}

	@Override
	public StudentDto addStudent(StudentDto stud) {
		Student newStud = modelMapper.map(stud, Student.class) ;
		Student added = repository.save(newStud) ;
		return modelMapper.map(added, StudentDto.class) ;
	}

	@Override
	public void rmvStud(Long id) {
		repository.deleteById(id);
	}

	@Override
	public StudentDto upWhlStud(Long id, StudentDto updStud) {
		Student existingStud = repository.findById(id).get() ;
		modelMapper.map(updStud, existingStud); 
		Student updtedStudent = repository.save(existingStud) ;
		return modelMapper.map(updtedStudent, StudentDto.class);
	}
}