package com.kangamit.gestionstockbackend.features.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kangamit.gestionstockbackend.features.customer.entity.Customer;
import com.kangamit.gestionstockbackend.features.customer.repository.CustomerRepository;
import com.kangamit.gestionstockbackend.features.customer.service.CustomerService;

@Controller
@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/createCustomer")
	public Customer save(@RequestBody Customer customer) {
		return customerService.create(customer);
	}
	
	@GetMapping("/listCustomer")
	public List<Customer> findAllSupplier() {
		return customerService.ListOfCustomer();
	}
	
	@PutMapping("/updateCustomer/{id}")
	public Customer update(@RequestBody Customer customer, @PathVariable Long id) {
		Optional<Customer> result = customerRepository.findById(id);
		Customer customers = null;
		if(result.isPresent()) {
			customers = result.get();
			customers.setFirstName(customer.getFirstName());
			customers.setLastName(customer.getLastName());
			customers.setAddress(customer.getAddress());
			customers.setEmail(customer.getEmail());
			customers.setCode(customer.getCode());
			customers.setPhoneNumber(customer.getPhoneNumber());
		}
		customers = customerRepository.save(customers);
		return customers;
	}

}
