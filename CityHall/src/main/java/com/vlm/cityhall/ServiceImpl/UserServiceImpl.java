package com.vlm.cityhall.ServiceImpl;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


import com.vlm.cityhall.DAO.UserDao;
import com.vlm.cityhall.ENTITY.User;
import com.vlm.cityhall.SecurityConfig.JwtFilter;
import com.vlm.cityhall.SecurityConfig.JwtUtil;
import com.vlm.cityhall.SecurityConfig.UserDetailsServiceImpl;
import com.vlm.cityhall.Service.UserService;
import com.vlm.cityhall.constents.CityHallConstants;
import com.vlm.cityhall.utils.CityHallUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	JwtFilter jwtFilter;
	
	

	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		try {
		if(validateSignUpMap(requestMap)){
			User user = userDao.findByEmailId(requestMap.get("email"));
			if(Objects.isNull(user)) {
				userDao.save(getUserFromMap(requestMap));
				return CityHallUtils.getResponseEntity("Successfully Registered", HttpStatus.OK);
			}
			else {
				return CityHallUtils.getResponseEntity("Email already exist.", HttpStatus.BAD_REQUEST);
			}
		}
		else {
			return CityHallUtils.getResponseEntity(CityHallConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
		}
	}catch (Exception ex) {
		ex.printStackTrace();
	}
		return CityHallUtils.getResponseEntity(CityHallConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	private boolean validateSignUpMap(Map<String, String> requestMap) {
		if(requestMap.containsKey("firstName") && requestMap.containsKey("lastName")
		&& requestMap.containsKey("email") && requestMap.containsKey("password")
		&& requestMap.containsKey("birthDay") && requestMap.containsKey("birthPlace"))
		{
			return true;
		}
		return false;
	
	}
	
	
	private User getUserFromMap(Map<String, String> requestMap) {
		User user = new User();
		user.setFirstName(requestMap.get("firstName"));
		user.setLastName(requestMap.get("lastName"));
		user.setEmail(requestMap.get("email"));
		user.setPassword(requestMap.get("password"));
		user.setBirthDay(LocalDate.parse(requestMap.get("birthDay")) );
		user.setBirthPlace(requestMap.get("birthPlace"));
		user.setStatus("true");
		user.setRole("user");
		return user;
	}
	
	
	
	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		log.info("Inside login");
		try {
			Authentication auth = authenticationManager.authenticate(
							new UsernamePasswordAuthenticationToken(requestMap.get("email"), requestMap.get("password"))
					);
			if(auth.isAuthenticated()) {
				if(userDetailsServiceImpl.getUserDetail().getStatus().equalsIgnoreCase("true")) {
					return new ResponseEntity<String>("{\"token\":\""+
				jwtUtil.generateToken(userDetailsServiceImpl.getUserDetail().getEmail(),
						userDetailsServiceImpl.getUserDetail().getRole()) + "\"}",
					HttpStatus.OK);
				}
				else {
					return new ResponseEntity<String>("{\"message\":\""+"Wait for admin approval."+"\"}",
							HttpStatus.BAD_REQUEST);
				}
			}
		}catch (Exception ex) {
			log.error("{}", ex);
		}
		return new ResponseEntity<String>("{\"message\":\""+"Bad Credentials."+"\"}",
				HttpStatus.BAD_REQUEST);
	}
	
	

	@Override
	public ResponseEntity<String> update(Map<String, String> requestMap) {
		log.info("Inside update");
		try {
			if(jwtFilter.isAdmin()) {
				 Optional<User> optional = userDao.findById(Integer.parseInt(requestMap.get("id")));
				 if(!optional.isEmpty()) {
					  userDao.updateStatus(requestMap.get("status"),Integer.parseInt(requestMap.get("id")));
					  
					  return CityHallUtils.getResponseEntity("User Status Updated Successfully", HttpStatus.OK);
				 }
				 else {
					return CityHallUtils.getResponseEntity("User id does not exit", HttpStatus.OK); 
				 }
			}else {
				return CityHallUtils.getResponseEntity(CityHallConstants.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return CityHallUtils.getResponseEntity(CityHallConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	@Override
	public ResponseEntity<String> checkToken() {
		return CityHallUtils.getResponseEntity("true", HttpStatus.OK);
	}
	
	

	@Override
	public ResponseEntity<String> changePassword(Map<String, String> requestMap) {
		try {
			 User userObj = userDao.findByEmailId(jwtFilter.getCurrentUser());
			 if(!userObj.equals(null)) {
				 if(userObj.getPassword().equals(requestMap.get("oldPassword"))) {
					 userObj.setPassword(requestMap.get("newPassword"));
					 userDao.save(userObj);
					 return CityHallUtils.getResponseEntity("Password Updated Successfully", HttpStatus.OK);
				 }
				 return CityHallUtils.getResponseEntity("Incorrect Old Password", HttpStatus.BAD_REQUEST);
			 }
			 return CityHallUtils.getResponseEntity(CityHallConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return CityHallUtils.getResponseEntity(CityHallConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	
	}

	
	
	

}
