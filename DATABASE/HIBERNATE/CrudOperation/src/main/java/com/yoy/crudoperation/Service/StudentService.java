package com.yoy.crudoperation.Service;

import com.yoy.crudoperation.Entity.Student;

public interface StudentService 
{
	public void insertStudSrvc(Student students) ;
	public void deleteStudSrvc(Student students) ;
	public void updateStudSrvc(Student students) ;
	public void updateCursSrvc(Long id , String newCourse) ;
	public void retrieveStudSrvc(Long rollno) ; 	
}