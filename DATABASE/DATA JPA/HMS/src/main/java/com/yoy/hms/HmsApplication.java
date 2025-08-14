package com.yoy.hms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yoy.hms.entity.Patient;
import com.yoy.hms.repository.PatientRepository;

@SpringBootApplication
public class HmsApplication implements CommandLineRunner
{
	@Autowired
	private PatientRepository repository ;
	
	public static void main(String[] args) {
		SpringApplication.run(HmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
//		List<Patient> patients = repository.findAll() ;
//		System.out.println(patients);
	}

}
