package com.yoy.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoy.hms.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
