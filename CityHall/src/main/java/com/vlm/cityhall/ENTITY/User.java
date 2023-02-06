package com.vlm.cityhall.ENTITY;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.vlm.cityhall.model.CertificateOfResidence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NamedQuery(name = "User.findByEmailId",query = "select u from User u where u.email=:email")

@NamedQuery(name = "User.updateStatus", query = "update User u set u.status=:status  where u.id=:id")



@Entity
@Data
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 123456L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "birthDay")
	private LocalDate birthDay;
	
	@Column(name = "birthPlace")
	private String birthPlace;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_fk", nullable = false)
	private Collection<Role> roles;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private CertificateOfResidence CertificateOfResidences;
	
	@Column(name = "status")
	private String status;

	@Column(name = "role")
	private String role;
	

}
