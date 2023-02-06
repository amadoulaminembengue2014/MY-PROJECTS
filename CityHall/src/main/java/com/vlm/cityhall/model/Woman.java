package com.vlm.cityhall.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.vlm.cityhall.ENTITY.User;

@Entity
public class Woman extends User {
	@OneToOne(mappedBy = "woman")
	private Wedding wedding;
	private String sexe = "FEMME";
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
