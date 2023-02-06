package com.vlm.cityhall.RestImpl;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.cityhall.Rest.UserRest;
import com.vlm.cityhall.Service.UserService;
import com.vlm.cityhall.constents.CityHallConstants;
import com.vlm.cityhall.utils.CityHallUtils;



@RestController
public class UserRestImpl implements UserRest {
	
	@Autowired
	private UserService userService;

	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		try {
			return userService.signUp(requestMap);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return CityHallUtils.getResponseEntity(CityHallConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
	
	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		try {
			return userService.login(requestMap);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return CityHallUtils.getResponseEntity(CityHallConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	


	@Override
	public ResponseEntity<String> update(Map<String, String> requestMap) {
		try {
			return userService.update(requestMap);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return CityHallUtils.getResponseEntity(CityHallConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

	}


	
	@Override
	public ResponseEntity<String> checkToken() {
		try {
			return userService.checkToken();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return CityHallUtils.getResponseEntity(CityHallConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

	}


	@Override
	public ResponseEntity<String> changePassword(Map<String, String> requestMap) {
		try {
			return userService.changePassword(requestMap);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return CityHallUtils.getResponseEntity(CityHallConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	
}
