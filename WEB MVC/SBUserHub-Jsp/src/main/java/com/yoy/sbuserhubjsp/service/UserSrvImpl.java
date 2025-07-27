package com.yoy.sbuserhubjsp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yoy.sbuserhubjsp.entity.User;
import com.yoy.sbuserhubjsp.repository.UserRepository;

@Service
public class UserSrvImpl implements UserService
{
	private final UserRepository userRepo ;

	public UserSrvImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Transactional
	@Override
	public User addUser(User user) {
		try {
			return userRepo.save(user) ;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional (readOnly = true)
	@Override
	public User findById(long id) {
		try {
			return userRepo.findById(id).get() ;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
