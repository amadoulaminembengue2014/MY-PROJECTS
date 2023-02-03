<<<<<<< HEAD
package com.vlm.cityhall.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlm.cityhall.ENTITY.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {
	
	List<Role> getAllRole();

}
=======
package com.vlm.cityhall.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlm.cityhall.ENTITY.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {
	
	List<Role> getAllRole();

}
>>>>>>> 41d800b8c58ee17a9957d985d53e4b53ee67a7e3
