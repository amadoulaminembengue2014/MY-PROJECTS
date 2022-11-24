package com.vlm.springboot.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@Column(name = "email_id")
	private String emailId;
	
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "addrees")
	private String address;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "salary")
	private String salary;
	
	@Column(name = "date_hired")
	private LocalDate dateHired;
	
	@Column(name = "job_tiltle")
	private String jobTitle;
	
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "image")
	private String image;
	
	
	public Employee() {
		
	}
	
	public Employee(Long id, String firstName, String lastName, Date dateOfBirth, String emailId, String telephone,
			String address, String department, String gender, String salary, LocalDate dateHired, String jobTitle,
			String password, String image) {
		super();
		this.id = id;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Employee getEmployeeByEmailId(String myEmailId) {
		// TODO Auto-generated method stub
		return null;
	}

}
