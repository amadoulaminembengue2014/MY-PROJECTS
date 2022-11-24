package com.vlm.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.springboot.exception.RessourceNotFoundException;
import com.vlm.springboot.model.Employee;
import com.vlm.springboot.repository.EmployeeRepository;
import com.vlm.springboot.service.EmployeeService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private EmployeeService employeeservice;
	
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin(origins = "http://localhost:4200")
	public Employee regEmployee(@RequestBody final Employee employee) throws Exception {
		String tempEmailId=employee.getEmailId();
		if(tempEmailId !=null && !"".equals(tempEmailId)) {
			Employee employeeObj =	employeeservice.fetchEmployeeByEmailId(tempEmailId);
		 if(employeeObj!=null) {
			 throw new Exception("Employee with"+tempEmailId+"Already exist ");
		 }
		}
		Employee employeeObj=null;
		employeeObj = employeeservice.CreateEmployee(employee);
		return employeeObj;
		
	}
	
	//sign in Employee
	@PostMapping("/login")
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin(origins = "http://localhost:4200")
	public Employee loginEmployee(@RequestBody final Employee employee) throws Exception {
		String tempEmailId = employee.getEmailId();
		String tempPass = employee.getPassword();
		Employee employeeObj=null;
		if(tempEmailId !=null && tempPass !=null) {
			employeeObj = employeeservice.fetchEmployeeByEmailIdAndPassword(tempEmailId, tempPass);
			
		}
		if(employeeObj==null) {
			throw new Exception("Bad credentials");
		}
		return  employeeObj;
	}
	
	//All Employee
		@GetMapping("/AllEmployee")
		public ResponseEntity<List<Employee>>getAllEmployee(){
			List<Employee>employee = employeeservice.findAllEmployee();
			return new ResponseEntity<>(employee ,HttpStatus.OK);
		}
		@GetMapping("/totalEmployee")
			@ResponseStatus(HttpStatus.OK)
			public long getTotalPatients() {
			return employeeservice.findAllEmployees();
				
			}


	
	
	
	/*
	 * @GetMapping("/login")
	 * 
	 * @CrossOrigin(origins = "http://localhost:4200") public String login() {
	 * return "authenticated successfully"; }
	 */
	  

    
	 
	
	
	
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepo.findAll();
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepo.save(employee);
	}
	
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Employee not exist with id :" + id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setPassword(employeeDetails.getPassword());
		employee.setDateOfBirth(employeeDetails.getDateOfBirth());
		employee.setTelephone(employeeDetails.getTelephone());
		employee.setAddress(employeeDetails.getAddress());
		employee.setDepartment(employeeDetails.getDepartment());
		employee.setGender(employeeDetails.getGender());
		employee.setSalary(employeeDetails.getSalary());
		employee.setDateHired(employeeDetails.getDateHired());
		employee.setJobTitle(employeeDetails.getJobTitle());
		employee.setImage(employeeDetails.getImage());
		
		
		Employee updatedEmployee = employeeRepo.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Employee not exist with id :" + id));
		
		employeeRepo.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
