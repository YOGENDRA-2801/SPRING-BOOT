package com.yoy.corecrud.service;

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

	@Override
	public void removeEmployee() {

	}

	@Override
	public void updateEmployee() {

	}

	@Override
	public void updateSalary() {

	}

	@Override
	public void getAllEmployee() {

	}

	@Override
	public void getEmployeeById() {

	}

}