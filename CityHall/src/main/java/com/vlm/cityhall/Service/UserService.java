package com.vlm.cityhall.Service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface UserService {

	public ResponseEntity<String> signUp(Map<String, String> requestMap);
}
