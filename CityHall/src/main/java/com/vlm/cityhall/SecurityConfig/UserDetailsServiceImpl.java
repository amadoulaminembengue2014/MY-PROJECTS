<<<<<<< HEAD
package com.vlm.cityhall.SecurityConfig;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vlm.cityhall.DAO.UserDao;

import lombok.extern.slf4j.Slf4j;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserDao userDao;
	
	private com.vlm.cityhall.ENTITY.User userDetail;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		userDetail = userDao.findByEmailId(username);
		if(!Objects.isNull(userDetail))
			return new User(userDetail.getEmail(), userDetail.getPassword(), new ArrayList<>());
		else 
			throw new UsernameNotFoundException("User not found.");
	}
	
	public com.vlm.cityhall.ENTITY.User getUserDetail(){
		return userDetail;
	}

}
=======
package com.vlm.cityhall.SecurityConfig;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vlm.cityhall.DAO.UserDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserDao userDao;
	
	private com.vlm.cityhall.ENTITY.User userDetail;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("Indide loadUserByUsername {}", username);
		userDetail = userDao.findByEmailId(username);
		if(!Objects.isNull(userDetail))
			return new User(userDetail.getEmail(), userDetail.getPassword(), new ArrayList<>());
		else 
			throw new UsernameNotFoundException("User not found.");
	}
	
	public com.vlm.cityhall.ENTITY.User getUserDetail(){
		return userDetail;
	}

}
>>>>>>> 41d800b8c58ee17a9957d985d53e4b53ee67a7e3
