package com.vlm.cityhall.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.vlm.cityhall.ENTITY.User;

@Entity
public class Man extends User {
	@OneToOne(mappedBy = "man")
	private Wedding wedding;
	private String sexe = "HOMME";
	public Wedding getWedding() {
		return wedding;
	}

	public void setWedding(Wedding wedding) {
		this.wedding = wedding;
	}

	public String getSexe() {
		return sexe;
	}
	
}
