package com.vlm.cityhall.Service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<String> signUp(Map<String, String> requestMap);

	ResponseEntity<String> login(Map<String, String> requestMap);

	ResponseEntity<String> update(Map<String, String> requestMap);

	ResponseEntity<String> checkToken();

	ResponseEntity<String> changePassword(Map<String, String> requestMap);


}