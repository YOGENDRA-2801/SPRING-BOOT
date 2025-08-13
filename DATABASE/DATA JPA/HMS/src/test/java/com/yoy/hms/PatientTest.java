package com.yoy.hms;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yoy.hms.entity.Patient;
import com.yoy.hms.repository.PatientRepository;

@SpringBootTest
public class PatientTest {
	
	@Autowired
	private PatientRepository repository ;
	
	@Test
	public void testPatientRepo() {
		List<Patient> allPatients = repository.findAll() ; 
		for (Patient patient : allPatients) {
			System.out.println(patient);
		}
	}
	
}
