package com.vlm.cityhall.Service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface RoleService {

	ResponseEntity<String> addNewRole(Map<String, String> requestMap);

}
