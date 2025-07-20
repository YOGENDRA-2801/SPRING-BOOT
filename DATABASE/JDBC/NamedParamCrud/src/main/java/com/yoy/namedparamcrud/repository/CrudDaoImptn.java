package com.yoy.namedparamcrud.repository;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yoy.namedparamcrud.beans.Users;

@Repository
public class CrudDaoImptn implements CrudDaoIntrfc
{
	private final NamedParameterJdbcTemplate namedParam ;
	
	public CrudDaoImptn(NamedParameterJdbcTemplate namedParam) {
		this.namedParam = namedParam;
	}

	@Override
	public boolean save(Users users) 
	{
		boolean status = false ;
		String sqlCmd = "INSERT INTO users (id, name, religion, city) VALUES (:id, :name, :religion, :city) ;" ;
		// Method 1: Using MapSqlParameterSource (Recommended)
		MapSqlParameterSource msps = new MapSqlParameterSource() ;
		msps.addValue("id", users.getId()) ;
		msps.addValue("name", users.getName()) ;
		msps.addValue("religion", users.getReligion()) ;
		msps.addValue("city", users.getCity()) ;
		int count = namedParam.update(sqlCmd, msps) ;
		if ( count>0 )  {  status = true ;  }
		return status ;
	}

	@Override
	public boolean remove(int id) 
	{
		boolean status = false ;
		String sqlCmd = "DELETE FROM users WHERE id=:userId ;" ;
		// Method 2: Using Map<String, Object>
		Map<String, Integer> params = new HashMap<String, Integer>() ;
		params.put("userId", id) ;
		int count = namedParam.update(sqlCmd, params) ;
		if ( count>0 )  {  status = true ;  }
		return status ;
	}

	@Override
	public boolean updateCity(int id, String newCity) 
	{
		boolean status = false ;
		String sqlCmd = "UPDATE users SET city=:nayaCity WHERE id=:userId ;" ;
		// Method 3: Using MapSqlParameterSource with method chaining
		MapSqlParameterSource mpsp = new MapSqlParameterSource()
				.addValue("nayaCity", newCity)
				.addValue("userId", id) ;
		int count = namedParam.update(sqlCmd, mpsp) ;
		if ( count>0 )  {  status = true ;  }
		return status ;
	}

	@Override
	public Users find(int id) 
	{
		String sqlCmd = "SELECT * FROM users WHERE id=:id ;" ;
		
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", id);
		Users users = namedParam.queryForObject(sqlCmd, params, useRowMapper()) ;
		return users ;
	}

	@Override
	public List<Users> findAll() 
	{
		String sqlCmd = "SELECT * FROM users ;" ;
		List<Users> userList =namedParam.query(sqlCmd, useRowMapper()) ;
		return userList ;
	}
	
	public RowMapper<Users> useRowMapper() {
		return (ResultSet rs, int rowNum) -> {
			Users user = new Users() ; 
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setReligion(rs.getString("religion"));
			user.setCity(rs.getString("city"));
			return user ;
		} ;		
	}
}
