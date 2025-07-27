package com.yoy.sbuserhubjsp.service;

import com.yoy.sbuserhubjsp.entity.User;

public interface UserService 
{
	public User addUser(User user) ;
	public User findById(long id) ;
}