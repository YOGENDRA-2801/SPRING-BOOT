package com.yoy.namedparamcrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.yoy.namedparamcrud.beans.Users;
import com.yoy.namedparamcrud.service.CrudSrvcIntrfc;

@SpringBootApplication
public class NamedParamCrudApplication implements CommandLineRunner
{
	private final CrudSrvcIntrfc crudOp ;
	
	public NamedParamCrudApplication(CrudSrvcIntrfc crudOp) {
		super();
		this.crudOp = crudOp;
	}

	public static void main(String[] args)  {  
		SpringApplication.run(NamedParamCrudApplication.class, args); 
	}
	
	@Bean Users user1()  {  return new Users (3, "Hitler", "Jewish", "Jaunpur") ;  }
	@Bean Users user2()  {  return new Users (2, "Tulsidas", "Atheist", "London") ;  }
	@Bean Users user3()  {  return new Users (1, "Yogendra", "Hindu", "Thane") ;  }

	@Override
	public void run(String... args) throws Exception 
	{
//		INSERT
		crudOp.createUser(user3());
		crudOp.createUser(user2());
		crudOp.createUser(user1());
		
//		SELECT
		crudOp.getUserById(2);
		
//		UPDATE
		crudOp.updateUsersCity(2, "NYC");
		
//		SELECT-ALL
		crudOp.getAllUsers();
		
//		DELETE
		crudOp.deleteUser(3);
		crudOp.deleteUser(2);
		crudOp.deleteUser(1);
		
//		SELECT-ALL
		crudOp.getAllUsers();		
	}
}
