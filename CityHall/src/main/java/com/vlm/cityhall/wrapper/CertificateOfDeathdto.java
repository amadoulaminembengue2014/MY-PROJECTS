package com.vlm.cityhall.wrapper;

import java.time.LocalDate;

import com.vlm.cityhall.ENTITY.User;

public class CertificateOfDeathdto {
	private Long id;
    private String cause_of_death;
    private String date_of_death;
    private User user;
    
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCause_of_death() {
		return cause_of_death;
	}
	public void setCause_of_death(String cause_of_death) {
		this.cause_of_death = cause_of_death;
	}
	public String getDate_of_death() {
		return date_of_death;
	}
	public void setDate_of_death(String date_of_death) {
		this.date_of_death = date_of_death;
	}
    
}
