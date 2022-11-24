package com.vlm.springboot.DTO;

import java.time.LocalDate;
import java.util.Date;


public class EmployeeDTO {
	
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String emailId;
	private String telephone;
	private String address;
	private String department;
	private String gender;
	private String salary;
	private LocalDate dateHired;
	private String jobTitle;
	private String password;
	private String image;
	
	public EmployeeDTO() {
		
	}
	

	public EmployeeDTO(String firstName, String lastName, Date dateOfBirth, String emailId, String telephone,
			String address, String department, String gender, String salary, LocalDate dateHired, String jobTitle,
			String password, String image) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.telephone = telephone;
		this.address = address;
		this.department = department;
		this.gender = gender;
		this.salary = salary;
		this.dateHired = dateHired;
		this.jobTitle = jobTitle;
		this.password = password;
		this.image = image;
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public LocalDate getDateHired() {
		return dateHired;
	}
	public void setDateHired(LocalDate dateHired) {
		this.dateHired = dateHired;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

}
