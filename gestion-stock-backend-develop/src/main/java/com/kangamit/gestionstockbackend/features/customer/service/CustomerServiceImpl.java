package com.kangamit.gestionstockbackend.features.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kangamit.gestionstockbackend.features.customer.entity.Customer;
import com.kangamit.gestionstockbackend.features.customer.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer create(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> ListOfCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer updateCustomer(Customer customer, Long id) {
		customer = customerRepository.findById(id).get();
		return customerRepository.save(customer);
		
	}

}
