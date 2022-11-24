package com.vlm.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.vlm.springboot.exception.ResourceNotFoundException;
import com.vlm.springboot.model.Employee;
import com.vlm.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	//create Employee
		public Employee CreateEmployee(Employee employee) {
			return employeeRepo.save(employee);	
		}

			public Employee fetchEmployeeByEmailId(String emailId) {
				return employeeRepo.findByEmailId(emailId);
			}
			
			public Employee fetchEmployeeByEmailIdAndPassword(String emailId,String password) {
				return employeeRepo.findByEmailIdAndPassword(emailId, password);
			}
			
		
				//find Employee
				public List<Employee>findAllEmployee(){
					return employeeRepo.findAll();	
				}
				//Update Employee
				public Employee UpdateEmployee(Employee employee) {
					return employeeRepo.save(employee);	
					
				}
				public long findAllEmployees() {
					List<Employee>employee=employeeRepo.findAll();
					long totalEmployees = employee.stream().count();
					return totalEmployees;
				}
				//find Employee by id
				public Employee findEmployeeById(Long id) {
					return employeeRepo.findById(id)
					.orElseThrow(()-> new ResourceNotFoundException("Employee by id"+id+"Was not Found"));
				}
				//delete Employee
				public void DeleteEmployee(Long id) {
					employeeRepo.deleteById(id);
				}


	

}
