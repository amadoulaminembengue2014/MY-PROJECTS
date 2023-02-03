<<<<<<< HEAD
package com.vlm.cityhall.Rest;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/user")
public interface UserRest {
	
	@PostMapping(path = "/signup")
	public ResponseEntity<String> signUp(@RequestBody(required = true) Map<String, String> requestMap);
	
	@PostMapping(path = "/login")
	public ResponseEntity<String> login(@RequestBody(required = true) Map<String, String> requestMap);

}
=======
package com.vlm.cityhall.Rest;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/user")
public interface UserRest {
	
	@PostMapping(path = "/signup")
	public ResponseEntity<String> signUp(@RequestBody(required = true) Map<String, String> requestMap);

}
>>>>>>> 41d800b8c58ee17a9957d985d53e4b53ee67a7e3
