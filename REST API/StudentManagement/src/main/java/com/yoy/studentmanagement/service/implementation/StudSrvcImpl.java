package com.yoy.studentmanagement.service.implementation;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.yoy.studentmanagement.dto.StudentDto;
import com.yoy.studentmanagement.dto.SaveStudentDto;
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
	public StudentDto addStudent(SaveStudentDto stud) {
		Student newStud = modelMapper.map(stud, Student.class) ;
		Student added = repository.save(newStud) ;
		return modelMapper.map(added, StudentDto.class) ;
	}

	@Override
	public void rmvStud(Long id) {
		repository.deleteById(id);
	}

	@Override
	public StudentDto upWhlStud(Long id, SaveStudentDto updStudDto) {
		Student existingStud = repository.findById(id).orElseThrow(
		        () -> new RuntimeException("Student not found with id: " + id)
		    );
		modelMapper.map(updStudDto, existingStud); 
		existingStud = repository.save(existingStud) ;
		return modelMapper.map(existingStud, StudentDto.class);
	}

	@Override
	public StudentDto patchUpdate(Long id, Map<String, Object> update) {
		Student existingStud = repository.findById(id).orElseThrow(
		        () -> new RuntimeException("Student not found with id: " + id)
		    );
		update.forEach( (field, value) -> {
			switch (field) {
			case "name": {
				existingStud.setName(value.toString()) ;
				break;
			}
			case "email": {
				existingStud.setEmail(value.toString()) ;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + field);
			}
		} );
		Student parUpdStudent = repository.save(existingStud) ;
		return modelMapper.map(parUpdStudent, StudentDto.class);
	}
}




















