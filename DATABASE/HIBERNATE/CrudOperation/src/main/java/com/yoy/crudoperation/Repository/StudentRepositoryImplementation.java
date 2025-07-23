package com.yoy.crudoperation.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.yoy.crudoperation.Entity.Student;

import jakarta.transaction.Transactional;

@Repository
public class StudentRepositoryImplementation implements StudentRepository
{	
	private SessionFactory sf ;
	
	public StudentRepositoryImplementation(SessionFactory sf) {
	super();
	this.sf = sf;
	}

	@Transactional
	@Override
	public void insertStudent(Student students) {
		Session session = sf.getCurrentSession() ;
		session.persist(students);
	}

	@Transactional
	@Override
	public void deleteStudent(Long id) {
		Session session = sf.getCurrentSession();
		Student stud = session.get(Student.class, id) ;
		session.remove(stud); // requires a persistent instance 
	}

	@Transactional
	@Override
	public boolean updateStudent(Student students) {
		Session session = sf.getCurrentSession();
		Student stud = session.merge(students);
		return stud != null ; // will return true or false based on condition
	}

	@Transactional
	@Override
	public boolean updateCourse(Long id, String newCourse) {
		Session session = sf.getCurrentSession();
		Student stud = session.get(Student.class, id) ;
		stud.setCourse(newCourse);
		Student updtStud = session.merge(stud);
		return updtStud != null ;
	}

	@Override
	public Student retrieveStudent(Long id) {
		Session session = sf.openSession();
		Student stud = session.get(Student.class, id) ;
		return stud ;
	}	
}