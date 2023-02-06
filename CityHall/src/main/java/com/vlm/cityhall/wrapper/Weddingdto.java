package com.vlm.cityhall.wrapper;

import java.time.LocalDate;

import com.vlm.cityhall.model.Man;
import com.vlm.cityhall.model.Woman;

public class Weddingdto {
	private Long id;
    private String date_of_wedding;
    private String location;
    private Man man;
    private Woman woman;
    
	public Man getMan() {
		return man;
	}
	public void setMan(Man man) {
		this.man = man;
	}
	public Woman getWoman() {
		return woman;
	}
	public void setWoman(Woman woman) {
		this.woman = woman;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate_of_wedding() {
		return date_of_wedding;
	}
	public void setDate_of_wedding(String date_of_wedding) {
		this.date_of_wedding = date_of_wedding;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
    
}
