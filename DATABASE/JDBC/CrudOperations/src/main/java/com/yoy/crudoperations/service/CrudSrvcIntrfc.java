package com.yoy.crudoperations.service;

import com.yoy.crudoperations.beans.Users;

public interface CrudSrvcIntrfc 
{
	public void createUser(Users employee);
	public void updateUsersCity(int id, String city);
	public void getUserById(int id);
	public void getAllUsers();
	public void deleteUser(int id);
}

// Lambda me tu sirf parameters aur body deta hai:
// Lambda Expression use-case -- Functional Interface Implementation
// Bas, lambda me exception handling thodi “implicit” hoti hai—tu directly body likh ke chala de, compiler samjhega!

// new keyword in spring boot -- 
//			1. new use nahi karna : @Repository, @Service, @Controller classes 
//									Database connections (Spring manage karta hai)
//									Other Spring beans
//			2. new use kar sakte ho : Data Objects (Entity, DTO, POJO) , Exception Objects
//									  Utility Objects (Scanner, List, Map) , Value Objects (String, Integer, Date)
//									  Anonymous/Lambda objects
//			3. Spring sirf business logic containers manage karta hai, simple objects tum khud bana sakte ho!