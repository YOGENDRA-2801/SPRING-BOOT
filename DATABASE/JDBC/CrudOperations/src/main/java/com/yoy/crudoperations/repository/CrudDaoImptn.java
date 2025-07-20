package com.yoy.crudoperations.repository;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yoy.crudoperations.beans.Users;

@Repository
public class CrudDaoImptn implements CrudDaoIntrfc
{
//	Field Injection  -- Less Preferred 
//	@Autowired
//	private JdbcTemplate jTemp ;
	
//	Constructor Injection -- Preferred way for DI
	private final JdbcTemplate jTemp ;
//	@Autowired - Not required if class me ek hi constructor h [spring khudse ess ek constructor ka use krkr DI krlega]
	public CrudDaoImptn(JdbcTemplate jTemp) {
		this.jTemp = jTemp;
	}

	@Override
	public boolean save(Users users) 
	{
		boolean status = false ;
		String sqlCmd = "INSERT INTO users (id, name, religion, city) VALUES (?,?,?,?) ;" ;
		Object[] paramVal = { users.getId() , users.getName() , users.getReligion() , users.getCity() } ;
		int count = jTemp.update(sqlCmd, paramVal) ;
		if ( count>0 ) { status = true ; } 
		return status ;
	}

	@Override
	public boolean remove(int id) 
	{
		boolean status = false ;
		String sqlCmd = "DELETE FROM users WHERE id=? ;" ;
		int count = jTemp.update(sqlCmd, id) ;
		if ( count>0 ) { status = true ; } 
		return status ;
	}

	@Override
	public boolean updateCity(int id, String newCity) 
	{
		boolean status = false ;
		String sqlCmd = "UPDATE users SET city=? WHERE id=? ;" ;
		int count = jTemp.update(sqlCmd, newCity, id) ;
		if ( count>0 ) { status = true ; } 
		return status ;
	}

	@Override
	public Users find(int id) 
	{
		String sqlCmd = "SELECT * FROM users WHERE id=? ;" ;
		Users users = jTemp.queryForObject(sqlCmd, useRowMapper(), id) ;
		return users ;
	}

	@Override
	public List<Users> findAll() 
	{
		String sqlCmd = "SELECT * FROM users;" ;
		List<Users> userList = jTemp.query(sqlCmd, useRowMapper()) ;
		return userList ;
	}
	
	public RowMapper<Users> useRowMapper() {
		return (ResultSet rs, int rowNum) -> {
// lambda me throws SQLException explicitly likhne ki zaroorat nahi hoti, kyunki RowMapper ke mapRow method ki signature me pehle se hi likha hai. lambda me syntax concise hai, isliye throws SQLException dikhta nahi.
			Users user = new Users() ; 
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setReligion(rs.getString("religion"));
			user.setCity(rs.getString("city"));
			return user ;
		} ;		
	}
}
