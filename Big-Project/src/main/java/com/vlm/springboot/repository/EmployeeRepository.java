package com.vlm.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlm.springboot.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	public Employee findByEmailId(String emailId);
	Employee findByEmailIdAndPassword(String emailId, String password);
	

}
