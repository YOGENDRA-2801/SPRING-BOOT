package com.yoy.namedparamcrud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yoy.namedparamcrud.beans.Users;
import com.yoy.namedparamcrud.repository.CrudDaoIntrfc;

@Service
public class CrudSrvcImptn implements CrudSrvcIntrfc
{
	private final CrudDaoIntrfc daoCrud ;
	
//	@Autowired
	public CrudSrvcImptn(CrudDaoIntrfc daoCrud) {
		this.daoCrud = daoCrud;
	}

	@Override
	public void createUser(Users users) {
		try {
			boolean status = daoCrud.save(users) ;
			if (status) {
				System.out.println("Insertion Operation Performed Successfully");
			}
			else {
				throw new Exception() ;
			}
		} catch (Exception e) {
			System.out.println("\n\nUnable to perform insert operation\n\n");
			e.printStackTrace();
		}
	}

	@Override
	public void updateUsersCity(int id, String city) {
		try {
			boolean status = daoCrud.updateCity(id, city) ;
			if (status) {
				System.out.println("Update Operation Performed Successfully");
			}
			else {
				throw new Exception() ;
			}
		} catch (Exception e) {
			System.out.println("\n\nUnable to perform update operation\n\n");
			e.printStackTrace();
		}
	}

	@Override
	public void getUserById(int id) {
		try {
			Users user = daoCrud.find(id) ;
			if (user != null) {
				user.display();
			}
			else {
				throw new Exception() ;
			}
		} catch (Exception e) {
			System.out.println("\n\nUnable to perform search operation\n\n");
			e.printStackTrace();
		}
	}

	@Override
	public void getAllUsers() {
		try {
			List<Users> userList = daoCrud.findAll() ;
			if (userList != null) {
				for (Users users : userList) {
					users.display();
				}
			}
			else {
				throw new Exception() ;
			}
		} catch (Exception e) {
			System.out.println("\n\nUnable to perform search operation\n\n");
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int id) {
		try {
			boolean status = daoCrud.remove(id) ;
			if (status) {
				System.out.println("Delete Operation Performed Successfully");
			}
			else {
				throw new Exception() ;
			}
		} catch (Exception e) {
			System.out.println("\n\nUnable to perform delete operation\n\n");
			e.printStackTrace();
		}
	}
	
}
