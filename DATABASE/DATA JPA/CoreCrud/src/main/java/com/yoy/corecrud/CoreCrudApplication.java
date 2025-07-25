package com.yoy.corecrud;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.yoy.corecrud.entity.Employee;
import com.yoy.corecrud.service.EmployeeService;

@SpringBootApplication
public class CoreCrudApplication implements CommandLineRunner {
	
	private final EmployeeService empsrv ;

	public CoreCrudApplication(EmployeeService empsrv) {
		super();
		this.empsrv = empsrv;
	}

	public static void main(String[] args) {
		SpringApplication.run(CoreCrudApplication.class, args);
	}

	@Bean Employee emp1() { return new Employee("Yogendra", "Software", "Developer", new BigDecimal(56789.43)) ; }
	@Bean Employee emp2() { return new Employee("Krishna", "Marketing", "SEO Trainee", new BigDecimal(46789.43)) ; }
	@Bean Employee emp3() { return new Employee("Supreme", "Quality", "Tester", new BigDecimal(36789.43)) ; }

	@Override
	public void run(String... args) throws Exception {
		
//		INSERT
		empsrv.addEmployee(emp1());
		empsrv.addEmployee(emp2());
		empsrv.addEmployee(emp3());
		
//		UPDATE
//		empsrv.updateSalary(1L, new BigDecimal(99999.989));
		
//		SELECT 
//		empsrv.getAllEmployee();
//		empsrv.getEmployeeById(2L);
		
//		DELETE
//		empsrv.removeEmployee(1L);
//		empsrv.removeEmployee(2L);
//		empsrv.removeEmployee(3L);
	}
}
