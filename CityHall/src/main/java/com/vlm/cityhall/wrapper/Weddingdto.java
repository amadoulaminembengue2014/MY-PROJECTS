package com.vlm.cityhall.wrapper;

import java.time.LocalDate;

public class Weddingdto {
	private Long id;
    private String date_of_wedding;
    private String location;
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
