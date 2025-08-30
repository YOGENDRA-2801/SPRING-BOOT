package com.yoy.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoy.hms.entity.Insurance;
import com.yoy.hms.entity.Patient;
import com.yoy.hms.repository.InsuranceRepository;
import com.yoy.hms.repository.PatientRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class InsuranceService 
{
	private final PatientRepository patientRepo ;
	private final InsuranceRepository insuranceRepo ;

	@Autowired
	public InsuranceService(PatientRepository patientRepo, InsuranceRepository insuranceRepo) {
		super();
		this.patientRepo = patientRepo;
		this.insuranceRepo = insuranceRepo ;
	}
	
	@Transactional
	public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
		Patient patient = patientRepo.findById(patientId)
				.orElseThrow( () -> new EntityNotFoundException("Patient not found with id: "+patientId) )  ;
		patient.setInsurance(insurance);
//		Insurance will also gon'na pushed to persistence context with the help of cascade type bcoz insurance is inverse side of patient
		insurance.setPatient(patient); // bidirectional consistency maintenance
		return patient ;
	}
	
	
}
