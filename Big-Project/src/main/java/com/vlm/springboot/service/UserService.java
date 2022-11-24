package com.vlm.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.vlm.springboot.DTO.UserDTO;
import com.vlm.springboot.model.User;
import com.vlm.springboot.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	

	@SuppressWarnings("unused")
	private UserDTO convertEntityToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail(user.getEmail());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setPassword(user.getPassword());
		
		return userDTO;

	}




	public UserRepository getUserRepository() {
		return userRepository;
	}




	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
}
