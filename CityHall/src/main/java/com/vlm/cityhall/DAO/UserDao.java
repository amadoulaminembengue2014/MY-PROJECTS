package com.vlm.cityhall.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vlm.cityhall.ENTITY.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	User findByEmailId(@Param("email") String email);

}
