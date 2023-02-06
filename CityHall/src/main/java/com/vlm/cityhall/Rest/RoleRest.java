package com.vlm.cityhall.Rest;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/role")
public interface RoleRest {
	
	@PostMapping(path = "/add")
	ResponseEntity<String> addNewRole(@RequestBody(required = true) Map<String, String> requestMap);

}
