package com.vlm.shop.RestImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.shop.Constents.ShopConstants;
import com.vlm.shop.Rest.UserRest;
import com.vlm.shop.Service.UserService;
import com.vlm.shop.Utils.ShopUtils;
import com.vlm.shop.Wrapper.UserWrapper;

@RestController
public class UserRestImpl implements UserRest {
	
	@Autowired
	UserService userService;

	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		try {
			return userService.signup(requestMap);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return ShopUtils.getResponseEntity(ShopConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		try {
			return userService.login(requestMap);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return ShopUtils.getResponseEntity(ShopConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	@Override
	public ResponseEntity<List<UserWrapper>> getAllUser() {
		try {
			return userService.getAllUser();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<List<UserWrapper>>( new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}


	@Override
	public ResponseEntity<String> update(Map<String, String> requestMap) {
		try {
			return userService.update(requestMap);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return ShopUtils.getResponseEntity(ShopConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
