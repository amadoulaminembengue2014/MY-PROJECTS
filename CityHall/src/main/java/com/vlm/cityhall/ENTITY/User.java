package com.vlm.cityhall.ENTITY;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

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

import com.vlm.cityhall.model.CertificateOfBirth;
import com.vlm.cityhall.model.CertificateOfDeath;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NamedQuery(name = "User.findByEmailId",query = "select u from User u where u.email=:email")

@Entity
@Data
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
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
	
	@Column(name = "telephone")
	private String tel;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_fk", nullable = false)
	private Collection<Role> roles;
	
	@Column(name = "status")
	private String status;
	@Column(name = "role")
	private String role;
	
	@OneToOne(mappedBy = "user")
	private CertificateOfBirth certificateOfBirth;
	
	@OneToOne(mappedBy = "user")
	private CertificateOfDeath certificateOfDeath;
	
	public User() {
	}
	public User(Integer id, String firstName, String lastName, LocalDate birthDay, String birthPlace, String password,
			String email, String tel, Collection<Role> roles, String status, String role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.birthPlace = birthPlace;
		this.password = password;
		this.email = email;
		this.tel = tel;
		this.roles = roles;
		this.status = status;
		this.role = role;
	}
	
	public CertificateOfBirth getCertificateOfBirth() {
		return certificateOfBirth;
	}
	public void setCertificateOfBirth(CertificateOfBirth certificateOfBirth) {
		this.certificateOfBirth = certificateOfBirth;
	}
	public CertificateOfDeath getCertificateOfDeath() {
		return certificateOfDeath;
	}
	public void setCertificateOfDeath(CertificateOfDeath certificateOfDeath) {
		this.certificateOfDeath = certificateOfDeath;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
