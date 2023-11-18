package com.kangamit.gestionstockbackend.features.customer.service;


import java.util.List;
import com.kangamit.gestionstockbackend.features.customer.entity.Customer;


public interface CustomerService {
	
	Customer create(Customer customer);
	
	List<Customer> ListOfCustomer();
	
	Customer updateCustomer(Customer customer, Long id);

}
