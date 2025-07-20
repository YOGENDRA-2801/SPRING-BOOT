package com.yoy.namedparamcrud.repository;

import java.util.List;

import com.yoy.namedparamcrud.beans.Users;

public interface CrudDaoIntrfc 
{
	public boolean save(Users users) ;
	
	public boolean remove(int id) ;
	
	public boolean updateCity(int id, String newCity) ;
	
	public Users find(int id) ;
	public List<Users> findAll() ;
}

// Spring Boot creates NamedParameterJdbcTemplate bean using JdbcTemplate internally

// Parameter Setting Methods:
// 	 1. MapSqlParameterSource - Type-safe, fluent API
//	 2. Map<String, Object> - Simple key-value pairs
//	 3. BeanPropertySqlParameterSource - Automatically maps bean properties
// 	 4. SqlParameterSource - Base interface for custom implementations