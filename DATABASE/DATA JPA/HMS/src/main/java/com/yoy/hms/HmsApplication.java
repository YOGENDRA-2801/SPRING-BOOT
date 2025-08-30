package com.yoy.hms;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.yoy.hms.dto.BGCount;
import com.yoy.hms.entity.Insurance;
import com.yoy.hms.entity.Patient;
import com.yoy.hms.repository.InsuranceRepository;
import com.yoy.hms.repository.PatientRepository;
import com.yoy.hms.service.InsuranceService;
import com.yoy.hms.type.BloodGroup;

@SpringBootApplication
public class HmsApplication 
	implements CommandLineRunner
{
//	@Autowired
//	private PatientRepository repository ;
	@Autowired
	private InsuranceService insuranceService ;
	
	public static void main(String[] args) {
		SpringApplication.run(HmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		Insurance insurance = new Insurance("HdfcMaxLife", "HDFC", LocalDate.of(2030, 12, 31), null) ;
		Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);
		patient.toString() ;
		System.out.println(patient.getInsurance());
	}	
	
	public void methodJpqlNative() {
//		----- JPQ QUERY METHOD ----- 
//		Patient p1 = repository.findByBirthDate(LocalDate.of(1995, 05, 12)) ;
//		System.out.println(p1);
//		List<Patient> p2 = repository.findByBirthDateOrEmail(LocalDate.of(1995, 05, 12), "sneha.joshi@example.com") ;
//		for (Patient patient : p2) {
//			System.out.println(patient);
//		}
//		List<Patient> p3 = repository.findByGenderContainingOrderByIdDesc("F") ;
//		for (Patient patient : p3) {
//		System.out.println(patient);
//		}
//		
		
//		----- JPQL ----- 
//		List<Patient> p4 = repository.findByBloodGroup(BloodGroup.AB_POSITIVE) ;
//		for (Patient patient : p4) {
//			System.out.println(patient);
//		}
//		List<Patient> p4 = repository.bornAfterDate(LocalDate.of(1995, 01, 01)) ;
//		for (Patient patient : p4) {
//			System.out.println(patient);
//		}
//		List<Object[]> p5 = repository.countOfBloodType() ;
//		for (Object[] objects : p5) {
//			System.out.println(objects[0] + " -- " + objects[1]);
//		}
//		int p7 = repository.updateName("Batman", 1L) ;
//		System.out.println(p7);
//		List<BGCount> p8 = repository.countOfBloodType() ;
//		for (BGCount bg : p8) {
//			System.out.println(bg);
//		}
		
//		----- NATIVE ----- 
//		List<Patient> p6 = repository.findAllMareez() ;
//		for (Patient patient : p6) {
//			System.out.println(patient);
//		}
//		Page<Patient> p9 = repository.findAllMareez(PageRequest.of(0, 5, Sort.by("naam"))) ;
//		for (Patient patient : p9) {
//			System.out.println(patient);
//		}	
	}
	
	
}
