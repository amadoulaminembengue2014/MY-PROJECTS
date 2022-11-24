package com.vlm.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.vlm.springboot.model.Admin;
import com.vlm.springboot.repository.AdminRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	
	
	@GetMapping("/admin")
	public List<Admin> getAllAdmins(){
		return adminRepository.findAll();
	}
	
	@PostMapping("/admin")
	public Admin createAdmin(@RequestBody Admin admin) {
		return adminRepository.save(admin);
	}
	
	

}
