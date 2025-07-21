package com.yoy.crudoperation.Service;

import org.springframework.stereotype.Service;

import com.yoy.crudoperation.Entity.Student;
import com.yoy.crudoperation.Repository.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService {
	private final StudentRepository studRepo;

//	@Autowired -- For Constructor DI but @Autowired is not required if only one constructor is present spring will manage it
	public StudentServiceImplementation(StudentRepository studRepo) {
		super();
		this.studRepo = studRepo;
	}

	@Override
	public void insertStudSrvc(Student students) {
		try {
			studRepo.insertStudent(students);
			System.out.println("Student added successfully");
		} catch (Exception e) {
			System.out.println("Required Operation Cannot be performed due to following reason");
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudSrvc(Long id) {
		try {
			studRepo.deleteStudent(id);
			System.out.println("Student deleted successfully");
		} catch (Exception e) {
			System.out.println("Required Operation Cannot be performed due to following reason");
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudSrvc(Student students) {
		try {
			boolean status = studRepo.updateStudent(students);
			if (status) { System.out.println("Student updated successfully"); }	
			else { System.out.println("Operation not performed");	}
		} catch (Exception e) {
			System.out.println("Required Operation Cannot be performed due to following reason");
			e.printStackTrace();
		}
	}

	@Override
	public void updateCursSrvc(Long id, String newCourse) {
		try {
			boolean status = studRepo.updateCourse(id, newCourse) ;
			if (status) { System.out.println("Student updated successfully"); }	
			else { System.out.println("Operation not performed");	}
		} catch (Exception e) {
			System.out.println("Required Operation Cannot be performed due to following reason");
			e.printStackTrace();
		}
	}

	@Override
	public void retrieveStudSrvc(Long rollno) {
		try {
			Student stud = studRepo.retrieveStudent(rollno) ;
			stud.display();
		} catch (Exception e) {
			System.out.println("Required Operation Cannot be performed due to following reason");
			e.printStackTrace();
		}
	}

}