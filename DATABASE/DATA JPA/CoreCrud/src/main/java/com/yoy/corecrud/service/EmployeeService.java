package com.yoy.corecrud.service;

import java.math.BigDecimal;

import com.yoy.corecrud.entity.Employee;

public interface EmployeeService 
{
	public void addEmployee(Employee emp) ;
	public void removeEmployee(Long id) ;
	public void updateSalary(Long id, BigDecimal kamai) ;
	public void getAllEmployee() ;
	public void getEmployeeById(Long id) ;
}

/*
	TRANSACTION SUPPORT 
		1. enable annotation-driven transaction management using: @EnableTransactionManagement over configuration class or main class but this is optional as Spring Boot me by default transaction support enabled hota hai
		2. Jis method ko transactional banana hai (yaani ki agar koi error aaye to sab rollback ho jaye), us method pe @Transactional lagao
		3. Agar method sirf data read karta hai (kuch update nahi karta), to aise likho: @Transactional(readOnly = true) Ye performance thoda improve karta hai.
		4. @Transactional sirf public methods pe hi kaam karta hai.
		5. Transaction sirf tabhi apply hoga jab class ko Spring ne manage kiya ho (@Service, @Component, etc.) ya jab method Spring container ke through call ho
		6. Spring ka @Transactional by default sirf unchecked exceptions (yaani RuntimeException aur uske subclasses) par hi rollback karta hai.
		7. If we want ki @Transactional checked exception per bhi kaam kare then we have to mention it explicitly like this : 
		8. Declare like this if you want ki saare type ke exception per kaam kare : @Transactional(rollbackFor = Exception.class)  // Sabhi exceptions (checked + unchecked) pe rollback
		9. Agar Error pe bhi rollback chahiye then for this also we have to mention it explicitly but Error ka use rollback ke liye avoid karte hain kyunki ye mostly non-recoverable failures hote hain + DB ya memory in stable state me nahi hoti.
		10. @Transactional me hum isolation level (for concurrency control) aur propagation (method already transaction ke andar call ho) behavior bhi set kar sakte hain, jo control deta hai ki transaction doosre transactions ke saath kaise behave kare.
*/