package com.yoy.corecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yoy.corecrud.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
	
}

// We extend JpaRepository but not implement because of the following reason
//   1. Spring Data JPA खुद implementation provide करता है
//        जब आप JpaRepository को extend करते हैं, तो Spring framework runtime पर अपने आप उस interface का implementation बना देता है।
//   2. Implement करने का मतलब होता है: हर method define करो
//        अगर आप JpaRepository को implement करते, तो आपको उसमें defined सभी methods (जो कि बहुत सारे हैं) का खुद से implementation लिखना पड़ता 
//        यह बहुत time-consuming और unnecessary है।
//   3. Spring की Magic behind the scenes
//        @EnableJpaRepositories annotation के ज़रिए Spring runtime पर आपके द्वारा बनाए गए interface (UserRepository) के लिए एक proxy class बनाता है। 
//        यह proxy class actual database operations को manage करती है — यानि Spring auto-generate करता है implementation।
//		  SB Data JPA use करते समय @EnableJpaRepositories annotation explicitly लिखना ज़रूरी नहीं है क्योंकि SB automatically इसको configure कर देता है