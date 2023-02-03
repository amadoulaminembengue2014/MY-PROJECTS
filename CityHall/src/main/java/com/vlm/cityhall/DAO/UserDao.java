<<<<<<< HEAD
package com.vlm.cityhall.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vlm.cityhall.ENTITY.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	User findByEmailId(@Param("email") String email);

}
=======
package com.vlm.cityhall.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.vlm.cityhall.ENTITY.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	User findByEmailId(@Param("email") String email);

}
>>>>>>> 41d800b8c58ee17a9957d985d53e4b53ee67a7e3
