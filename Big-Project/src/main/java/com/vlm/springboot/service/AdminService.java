package com.vlm.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlm.springboot.DTO.AdminDTO;
import com.vlm.springboot.model.Admin;
import com.vlm.springboot.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	
	

	@SuppressWarnings("unused")
	private AdminDTO convertEntityToDTO(Admin admin) {
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setEmailId(admin.getEmailId());
		adminDTO.setPassword(admin.getPassword());
		adminDTO.setRole(admin.getRole());
		
		return adminDTO;
		
	}




	public AdminRepository getAdminRepository() {
		return adminRepository;
	}




	public void setAdminRepository(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

}
