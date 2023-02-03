<<<<<<< HEAD
package com.vlm.cityhall.Service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<String> signUp(Map<String, String> requestMap);

	ResponseEntity<String> login(Map<String, String> requestMap);
}
=======
package com.vlm.cityhall.Service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface UserService {

	public ResponseEntity<String> signUp(Map<String, String> requestMap);
}
>>>>>>> 41d800b8c58ee17a9957d985d53e4b53ee67a7e3
