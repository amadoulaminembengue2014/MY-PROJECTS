package com.kangamit.gestionstockbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kangamit.gestionstockbackend.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
