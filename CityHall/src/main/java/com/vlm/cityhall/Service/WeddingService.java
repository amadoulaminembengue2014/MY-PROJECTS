package com.vlm.cityhall.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlm.cityhall.Mapping.UserMapper;
import com.vlm.cityhall.Mapping.WeddingMapper;
import com.vlm.cityhall.model.Wedding;
import com.vlm.cityhall.repository.WeddingRepo;
import com.vlm.cityhall.serviceRepo.WeddingServiceRepo;
import com.vlm.cityhall.wrapper.Weddingdto;

@Service
public class WeddingService implements WeddingServiceRepo{
	@Autowired
	private WeddingMapper mapper;
	@Autowired
	private WeddingRepo repo;
	@Override
	public Weddingdto ceateWedding(Weddingdto weddingdto) {
		Wedding wedding = mapper.dtoTOentity(weddingdto);
		repo.save(wedding);
		return mapper.entityTOdto(wedding);
	}
	@Override
	public Weddingdto getWedding(Long id) {
		Weddingdto weddingdto = null;
		if (repo.findById(id).isPresent()) {
			weddingdto = mapper.entityTOdto(repo.findById(id).get());
		} else {
			throw new RuntimeException("This id is not valid !");
		}
		return weddingdto;
	}
	@Override
	public List<Weddingdto> listOfWedding() {
		List<Weddingdto> weddingdtos = new ArrayList<>();
		for (Wedding wedding : repo.findAll()) {
			Weddingdto weddingdto = mapper.entityTOdto(wedding);
			weddingdtos.add(weddingdto);
		}
		return weddingdtos;
	}
	@Override
	public Weddingdto updateWedding(Long id, Weddingdto weddingdto) {
		Weddingdto weddingdto1 = null;
		if (repo.findById(id).isPresent()) {
			Wedding wedding = repo.findById(id).get();
			wedding.setDate_of_wedding(LocalDate.parse(weddingdto.getDate_of_wedding()));
			wedding.setId(weddingdto.getId());
			wedding.setLocation(weddingdto.getLocation());
			weddingdto1 = mapper.entityTOdto(wedding);
			repo.save(wedding);
		}
		return weddingdto1;
	}
	@Override
	public void deleteWedding(Long id) {
		repo.deleteById(id);
	}
	
}
