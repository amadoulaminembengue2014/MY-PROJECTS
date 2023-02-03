package com.vlm.cityhall.serviceRepo;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.vlm.cityhall.wrapper.UserWrapper;

public interface UserService {
	UserWrapper saveUser(UserWrapper userWrapper);
	UserWrapper getUser(int id);
	List<UserWrapper> listOfUserWrappers();
	UserWrapper updateUser(int id, UserWrapper userWrapper);
	void deleteUser(int id);
}
