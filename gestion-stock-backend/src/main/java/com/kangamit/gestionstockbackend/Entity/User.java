package com.kangamit.gestionstockbackend.Entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kangamit.gestionstockbackend.Enum.Role;
import com.kangamit.gestionstockbackend.Enum.UserStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String address;
	private String phoneNumber;
	
	@OneToMany(mappedBy = "user")
	private Collection<Order> orders;
	
	@Enumerated(EnumType.ORDINAL)
	private UserStatusEnum userstatusenum;
	
	@Enumerated(EnumType.ORDINAL)
	private Role role;

}
