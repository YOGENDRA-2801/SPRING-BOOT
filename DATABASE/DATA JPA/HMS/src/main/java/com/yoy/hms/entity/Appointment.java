package com.yoy.hms.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@Column(nullable = false)
	private LocalDateTime appointmentTime ;
	
	@Column(length = 500)
	private String reason ;
	
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient patient ;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Doctor doctor ;

	public Appointment() {
		super();
	}
	public Appointment(LocalDateTime appointmentTime, String reason, Patient patient, Doctor doctor) {
		super();
		this.appointmentTime = appointmentTime;
		this.reason = reason;
		this.patient = patient;
		this.doctor = doctor ;
	}
	public Appointment(Long id, LocalDateTime appointmentTime, String reason, Patient patient, Doctor doctor) {
		super();
		this.id = id;
		this.appointmentTime = appointmentTime;
		this.reason = reason;
		this.patient = patient;
		this.doctor = doctor ;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(LocalDateTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", appointmentTime=" + appointmentTime + ", reason=" + reason + "]";
	}
	
}
