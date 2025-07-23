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
	
//	SessionFactory.getCurrentSession() :- 
//		1. Yah current session deta hai.
//		2. Given session tx ke saath bind hota hai (matlab tx start hoga toh session bhi create ho jayega).
//		3. Ek hi thread me jitni baar bhi getCurrentSession() call karoge, wahi same session milega.
	
//	SessionFactory.openSession() :- 
//		1. Ye har baar ek naya session object deta hai.
//		2. Given session tx se bind nahi hota, alag se close karna padta hai.
//		3. Har call par naya session milta hai, chahe thread wahi ho ya "tx ho ya na ho".
	
//	For Select Operation 
//		1. getCurrentSession() tabhi sahi se kaam karta hai jab koi transaction active ho (jaise ki Spring me @Transactional annotation use kiya ho).
//		2. Agar transaction nahi hai and getCurrentSession() use kiya toh error aa jata hai: "No Hibernate Session bound to thread..."
//		3. Isliye, ya toh transaction start karo (jaise @Transactional laga do), ya fir openSession() use karo jo transaction se bind nahi hota.
}
