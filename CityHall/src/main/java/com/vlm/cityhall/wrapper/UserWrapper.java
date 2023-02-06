package com.vlm.cityhall.wrapper;


import javax.persistence.Column;
import javax.persistence.OneToOne;

import com.vlm.cityhall.model.CertificateOfBirth;
import com.vlm.cityhall.model.CertificateOfDeath;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWrapper {
	
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String birthDay;
	
	private String birthPlace;

	private String email;
	
	private String password;
	
	private String role;

	private String status;
	
	private CertificateOfBirth certificateOfBirth;
	
	private CertificateOfDeath certificateOfDeath;
	
	private String tel;

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

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
