package com.vlm.cityhall.RestImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.cityhall.Rest.RoleRest;
import com.vlm.cityhall.Service.RoleService;
import com.vlm.cityhall.constents.CityHallConstants;
import com.vlm.cityhall.utils.CityHallUtils;

@RestController
public class RoleRestImpl implements RoleRest {
	
	@Autowired
	RoleService roleService;

	@Override
	public ResponseEntity<String> addNewRole(Map<String, String> requestMap) {
		try {
			return roleService.addNewRole(requestMap);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return CityHallUtils.getResponseEntity(CityHallConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
