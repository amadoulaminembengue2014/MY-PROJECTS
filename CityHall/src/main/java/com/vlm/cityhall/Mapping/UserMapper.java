package com.vlm.cityhall.Mapping;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.vlm.cityhall.ENTITY.User;
import com.vlm.cityhall.wrapper.UserWrapper;

@Component
public class UserMapper {
	
	public User dtoToEntity(UserWrapper userWrapper) {
		User user = new User();
		user.setBirthDay(LocalDate.parse(userWrapper.getBirthDay()));
		user.setBirthPlace(userWrapper.getBirthPlace());
		user.setEmail(userWrapper.getEmail());
		user.setFirstName(userWrapper.getFirstName());
		user.setLastName(userWrapper.getLastName());
		user.setPassword(userWrapper.getPassword());
		user.setRole(userWrapper.getRole());
		return user;
	}
	
	public UserWrapper EntityTodto(User user) {
		UserWrapper userWrapper = new UserWrapper();
		userWrapper.setId(user.getId());
		userWrapper.setBirthDay(user.getBirthDay().toString());
		userWrapper.setBirthPlace(user.getBirthPlace());
		userWrapper.setEmail(user.getEmail());
		userWrapper.setFirstName(user.getFirstName());
		userWrapper.setLastName(user.getLastName());
		userWrapper.setPassword(user.getPassword());
		userWrapper.setRole(user.getRole());
		return userWrapper;
	}

}
