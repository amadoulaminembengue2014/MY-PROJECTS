package com.vlm.cityhall.ServiceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vlm.cityhall.DAO.RoleDao;
import com.vlm.cityhall.ENTITY.Role;
import com.vlm.cityhall.SecurityConfig.JwtFilter;
import com.vlm.cityhall.Service.RoleService;
import com.vlm.cityhall.constents.CityHallConstants;
import com.vlm.cityhall.utils.CityHallUtils;


@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleDao categoryDao;
	
	@Autowired
	JwtFilter jwtFilter;

	@Override
	public ResponseEntity<String> addNewRole(Map<String, String> requestMap) {
		try {
			if(jwtFilter.isAdmin()) {
				if(validateRoleMap(requestMap, false)) {
					categoryDao.save(getRoleFromMap(requestMap, false));
					return CityHallUtils.getResponseEntity("User Added Successfully", HttpStatus.OK);
				}
			}
			else {
				return CityHallUtils.getResponseEntity(CityHallConstants.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return CityHallUtils.getResponseEntity(CityHallConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private boolean validateRoleMap(Map<String, String> requestMap, boolean validateId) {
		if(requestMap.containsKey("name")) {
			if(requestMap.containsKey("id") && validateId) {
				return true;
			}else if (!validateId){
				return true;
			}
		}
		return false;
	}
	
	private Role getRoleFromMap(Map<String, String> requestMap, boolean isAdd) {
		Role role = new Role();
		if(isAdd) {
			role.setId(Integer.parseInt(requestMap.get("id")));
		}
		role.setName(requestMap.get("name"));
		return role;
	}

}
