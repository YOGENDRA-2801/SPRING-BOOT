package com.yoy.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoy.hms.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
