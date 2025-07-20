package com.yoy.crudoperations.repository;

import java.util.List;

import com.yoy.crudoperations.beans.Users;

public interface CrudDaoIntrfc 
{
	public boolean save(Users users) ;
	
	public boolean remove(int id) ;
	
	public boolean updateCity(int id, String newCity) ;
	
	public Users find(int id) ;
	public List<Users> findAll() ;
}

// Spring JDBC converts SQLException (checked) → DataAccessException (unchecked)
// This enables clean exception bubbling without mandatory try-catch blocks.
// Exception FLOW: DAO → Service → @ControllerAdvice → HTTP Response

// DAO LAYER: No try-catch - let exceptions bubble up naturally
// Responsibility: Database operations only
// Spring auto-converts SQLException to DataAccessException

// SERVICE LAYER: Main exception handling hub  
// Catch technical exceptions (DataAccessException)
// Convert to business exceptions with meaningful messages
// Add logging for debugging

// @ControllerAdvice: Global HTTP response handling
// Catch exceptions thrown from the Service layer.
// Convert them into clean, consistent HTTP responses.
// Centralized and global exception handling across controllers using @RestControllerAdvice.


// CONTROLLER LAYER: Clean code
// No try-catch needed with @ControllerAdvice
// Focus on request/response mapping only

// NOTE:- Try-catch in DAO is optional and only needed for logging or very specific DB error handling.