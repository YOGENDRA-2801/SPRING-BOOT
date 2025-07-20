package com.yoy.namedparamcrud.service;

import com.yoy.namedparamcrud.beans.Users;

public interface CrudSrvcIntrfc 
{
	public void createUser(Users employee);
	public void updateUsersCity(int id, String city);
	public void getUserById(int id);
	public void getAllUsers();
	public void deleteUser(int id);
}

// BeanPropertySqlParameterSource
//   1. When to Use -- When parameters directly match bean property names (e.g., entire Users bean)
//   2. Cons -- Only works if parameter names match property names exactly, Less control.

// MapSqlParameterSource
//   1. Recommended -- When writing queries with multiple parameters or type safety is required
//   2. Pros -- Chainable , Type-safe , Fluent API , Readable

// Map<String, Object>
//   1. Best for quick and simple parameter sets (1–2 parameters)
//   2. Quick to write , Easy to debug , Not type-safe , No chaining
