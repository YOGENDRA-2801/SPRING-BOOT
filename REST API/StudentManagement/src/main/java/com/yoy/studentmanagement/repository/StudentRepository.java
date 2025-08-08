package com.yoy.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yoy.studentmanagement.entity.Student;

@Repository
public class StudentRepository extends JpaRepository<Student, Long>
{

}
