package com.yoy.corecrud.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yoy.corecrud.entity.Employee;
import com.yoy.corecrud.repository.EmployeeRepository;

@Service
public class EmpSrvcImpl implements EmployeeService {
	private final EmployeeRepository empRep;

//	@Autowired -- Not required for Constructor DI if single constructor is present
	public EmpSrvcImpl(EmployeeRepository empRep) {
		super();
		this.empRep = empRep;
	}

	@Transactional
	@Override
	public void addEmployee(Employee emp) {
		try {
			Employee majdoor = empRep.save(emp);
			if (majdoor != null) {
				System.out.println("INSERTION PERFORMED");
			} else {
				System.out.println("INSERTION NOT PERFORMED");
			}
		} catch (Exception e) {
			System.out.println("INSERTION FAILED DUE TO FOLLOWING REASON");
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void removeEmployee(Long id) {
		try {
			empRep.deleteById(id);
			System.out.println("DELETION PERFORMED");
		} catch (Exception e) {
			System.out.println("DELETION FAILED DUE TO FOLLOWING REASON");
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void updateSalary(Long id, BigDecimal kamai) {
		try {
			Employee emp = empRep.findById(id).get() ;
			emp.setSalary(kamai);
			Employee newEmp = empRep.save(emp) ;
			if (newEmp != null) {
				System.out.println("UPDATION PERFORMED");
			} else {
				System.out.println("UPDATION NOT PERFORMED");
			}
		} catch (Exception e) {
			System.out.println("UPDATION FAILED DUE TO FOLLOWING REASON");
			e.printStackTrace();
		}
	}

	@Transactional(readOnly = true)
	@Override
	public void getAllEmployee() {
		try {
			List<Employee> allEmp = empRep.findAll() ;
			if (allEmp != null) {
				for (Employee employee : allEmp) {
					employee.display();
				}
			} else {
				System.out.println("RETRIEVE NOT PERFORMED");
			}
		} catch (Exception e) {
			System.out.println("RETRIEVE FAILED DUE TO FOLLOWING REASON");
			e.printStackTrace();
		}		
	}

	@Transactional(readOnly = true)
	@Override
	public void getEmployeeById(Long id) {
		try {
			Employee emp = empRep.findById(id).get() ;
			if (emp != null) {
				emp.display();
			} else {
				System.out.println("RETRIEVE NOT PERFORMED");
			}
		} catch (Exception e) {
			System.out.println("RETRIEVE FAILED DUE TO FOLLOWING REASON");
			e.printStackTrace();
		}	
	}
}