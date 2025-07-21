package com.yoy.crudoperation;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.yoy.crudoperation.Entity.Student;
import com.yoy.crudoperation.Service.StudentService;

@SpringBootApplication
public class CrudOperationApplication implements CommandLineRunner
{
	private final StudentService service ;
	
	@Autowired
	public CrudOperationApplication(StudentService service) {
		super();
		this.service = service;
	}

	public static void main(String[] args) 
	{
		SpringApplication.run(CrudOperationApplication.class, args);
	}
	
	@Bean Student stud1() { return new Student("Yogendra", "BSCIT", new BigDecimal(456.82)) ; }
	@Bean Student stud2() { return new Student("Akash", "BCA", new BigDecimal(222.22)) ; }
	@Bean Student stud3() { return new Student("Satish", "BSCCS", new BigDecimal(333.33)) ; }

	@Override
	public void run(String... args) throws Exception 
	{
		service.insertStudSrvc(stud1());
		service.insertStudSrvc(stud2());
		service.insertStudSrvc(stud3());
	}
}

//  @Bean CommandLineRunner demo(StudentService service) { return -> { --- } ; }
//  This is a parameter DI + lambda approach