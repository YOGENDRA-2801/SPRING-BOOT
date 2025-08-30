package com.yoy.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoy.hms.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
