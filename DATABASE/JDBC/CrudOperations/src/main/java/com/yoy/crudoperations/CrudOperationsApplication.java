package com.yoy.crudoperations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.yoy.crudoperations.beans.Users;
import com.yoy.crudoperations.service.CrudSrvcIntrfc;

@SpringBootApplication
public class CrudOperationsApplication implements CommandLineRunner
{
	private final CrudSrvcIntrfc crudOp ;
	
	public CrudOperationsApplication(CrudSrvcIntrfc crudOp) {
		super();
		this.crudOp = crudOp;
	}

	public static void main(String[] args)  {  
		SpringApplication.run(CrudOperationsApplication.class, args); 
//		var ek Local Variable Type Inference Java 10 feature h jo compiler ko automatically variable ka type determine krne deta hai
//		var context = SpringApplication.run(CrudOperationsApplication.class, args);
//	    var crudOp = context.getBean(CrudSrvcIntrfc.class);
//		It's Manual Retrieval (LEGACY APPROACH)
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
	
//	Use cases for CommandLineRunner:
//		1. Initial data seeding
//		2. Database connectivity check
//		3. Application startup tasks
//		4. Configuration validation
	
}