package com.vlm.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vlm.springboot.exception.RessourceNotFoundException;
import com.vlm.springboot.model.User;
import com.vlm.springboot.repository.UserRepository;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
public class UserController {
	
	
	@Autowired
	private UserRepository userRepository;


	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		User user = userRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("User not exist with id :" + id));
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateuser(@PathVariable Long id, @RequestBody User userDetails){
		User user = userRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("User not exist with id :" + id));
		
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		
		User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}
}
