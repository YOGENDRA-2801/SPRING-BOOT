package com.yoy.hms.service;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoy.hms.entity.Appointment;
import com.yoy.hms.entity.Doctor;
import com.yoy.hms.entity.Patient;
import com.yoy.hms.repository.AppointmentRepository;
import com.yoy.hms.repository.DoctorRepository;
import com.yoy.hms.repository.PatientRepository;

import jakarta.transaction.Transactional;

@Service
public class AppointmentService {
	private AppointmentRepository appointmentRepository ;
	private PatientRepository patientRepository ;
	private DoctorRepository doctorRepository ;
	
//	@Autowired
	public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DoctorRepository doctorRepository) {
		super();
		this.appointmentRepository = appointmentRepository;
		this.patientRepository = patientRepository;
		this.doctorRepository = doctorRepository;
	}
	
	@Transactional
	public Appointment createNewAppointment(Long doctorId, Long patientId, Appointment appointment) {
		
		if ( appointmentRepository.findById(appointment.getId()).orElseThrow() != null ) {
			throw new IllegalArgumentException("Appointment with given id already exist hence either check detail and go with same or use another id");
		}
		
		Patient patient = patientRepository.findById(patientId).orElseThrow() ;
		Doctor doctor = doctorRepository.findById(doctorId).orElseThrow() ;
		
		appointment.setPatient( patient );
		appointment.setDoctor( doctor );
		
		patient.getAppointments().add(appointment) ; // yaha appointment list hai and hamare pass jo appointment hai wah bus ek single element(object) hai 
		doctor.getAppointments().add(appointment) ; // yaha appointment list hai and hamare pass jo appointment hai wah bus ek single element(object) hai 
		
		return appointmentRepository.save(appointment) ;		
	}
}
