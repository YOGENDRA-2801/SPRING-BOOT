package com.yoy.hms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yoy.hms.dto.BGCount;
import com.yoy.hms.entity.Patient;
import com.yoy.hms.type.BloodGroup ;



@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>
{
/*	----- JPA QUERY METHODS -----  
//	Patient findByName(String name) ;
//	Patient findByBirthDate(LocalDate birhtdate) ;
//	List<Patient> findByBirthDateOrEmail(LocalDate birhtdate, String email) ;
//	List<Patient> findByBirthDateBetween(LocalDate min, LocalDate max) ;
//	List<Patient> findByGenderContaining(String word) ;
//	List<Patient> findByGenderContainingOrderByIdDesc(String word) ;
*/
	
/*	----- JPQL -----  
//	@Query("SELECT p FROM Patient p WHERE p.bloodGroup=?1")  // ?1 , ?2 , ... jitne param utne numbered-Q-Mark & names are from Patient Class
//	List<Patient> findByBloodGroup(@Param("kuchBhiNaamChalega") BloodGroup bloodGroup) ;
//	@Query("SELECT p FROM Patient p WHERE p.birthDate > :janamTarik")  // named param query
//	List<Patient> bornAfterDate(@Param("janamTarik") LocalDate birhtdate) ;
//	@Query("SELECT p.bloodGroup , COUNT(p) FROM Patient p GROUP BY p.bloodGroup")  // GROUP BY
//	List<Object[]> countOfBloodType() ;
//	@Transactional   @Modifying  // MODYFYING & TX
//	@Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
//	int updateName(@Param("name") String name , @Param("id") Long id) ;
//	@Query("SELECT new com.yoy.hms.dto.BGCount(p.bloodGroup , COUNT(p))  FROM Patient p GROUP BY p.bloodGroup")  // PROJECTION
//	List<BGCount> countOfBloodType() ;
*/
	
	
/*	----- NATIVE QUERY -----  */
//	@Query(value = "SELECT * FROM patients", nativeQuery = true)  // here we will use actual table & column name
//	List<Patient> findAllMareez() ;
	@Query(value = "SELECT * FROM patients", nativeQuery = true)  // Pagination
	Page<Patient> findAllMareez(Pageable pageable) ;

	
}
















