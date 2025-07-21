package com.yoy.crudoperation.Repository;

import com.yoy.crudoperation.Entity.Student;

public interface StudentRepository 
{
	public void insertStudent(Student students) ;
	public void deleteStudent(Long id) ;
	public boolean updateStudent(Student students) ;
	public boolean updateCourse(Long id , String newCourse) ;
	public Student retrieveStudent(Long id) ; 
//	In order to fetch all records you have to use HQL or Criteria Api as there are no predefined method available in hibernate
}
