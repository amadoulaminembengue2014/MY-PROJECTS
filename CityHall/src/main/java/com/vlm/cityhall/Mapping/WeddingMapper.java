package com.vlm.cityhall.Mapping;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.vlm.cityhall.model.Wedding;
import com.vlm.cityhall.wrapper.Weddingdto;


@Component
public class WeddingMapper {
	public Wedding dtoTOentity(Weddingdto weddingdto) {
		Wedding wedding = new Wedding();
		wedding.setDate_of_wedding(LocalDate.parse(weddingdto.getDate_of_wedding()));
		wedding.setId(weddingdto.getId());
		wedding.setLocation(weddingdto.getLocation());
		return wedding;
	}
	
	public Weddingdto entityTOdto(Wedding wedding) {
		Weddingdto weddingdto = new Weddingdto();
		weddingdto.setDate_of_wedding(wedding.getDate_of_wedding().toString());
		weddingdto.setId(wedding.getId());
		weddingdto.setLocation(wedding.getLocation());
		return weddingdto;
	}
}
