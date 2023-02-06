package com.vlm.cityhall.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlm.cityhall.ENTITY.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {
	
	List<Role> getAllRole();

}
