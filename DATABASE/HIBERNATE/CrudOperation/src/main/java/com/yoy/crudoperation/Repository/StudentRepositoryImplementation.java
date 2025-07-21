package com.yoy.crudoperation.Repository;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.yoy.crudoperation.Entity.Student;

import jakarta.transaction.Transactional;

@Repository
public class StudentRepositoryImplementation implements StudentRepository
{
	private final HibernateTemplate hTemp ;

//	@Autowired 
	public StudentRepositoryImplementation(HibernateTemplate hTemp) {
		super();
		this.hTemp = hTemp;
	}

	@Transactional
	@Override
	public void insertStudent(Student students) {
		hTemp.persist(students);
	}

	@Transactional
	@Override
	public void deleteStudent(Student students) {
		hTemp.delete(students);
	}

	@Transactional
	@Override
	public boolean updateStudent(Student students) {
		Student stud = hTemp.merge(students) ;
		return stud != null ; // will return true or false based on condition
	}

	@Transactional
	@Override
	public boolean updateCourse(Long id, String newCourse) {
		Student stud = hTemp.get(Student.class, id) ;
		stud.setCourse(newCourse);
		Student updtStud = hTemp.merge(stud) ;
		return updtStud != null ;
	}

	@Override
	public Student retrieveStudent(Long id) {
		return hTemp.get(Student.class, id) ;
	}
	
}
