package com.vlm.cityhall.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlm.cityhall.Mapping.UserMapper;
import com.vlm.cityhall.model.Father;
import com.vlm.cityhall.repository.FatherRepo;
import com.vlm.cityhall.serviceRepo.FatherInt;
import com.vlm.cityhall.wrapper.Fatherdto;

@Service
public class FatherService implements FatherInt{
	@Autowired
	private UserMapper mapper;
	@Autowired
	private FatherRepo fatherRepo;
	@Override
	public Fatherdto saveFather(Fatherdto fatherdto) {
		Father father = mapper.dtoToEntity(fatherdto);
		fatherRepo.save(father);
		return mapper.EntityTodto(father);
	}
	@Override
	public Fatherdto getFather(int id) {
		Optional<Father> optional = fatherRepo.findById(id);
		Fatherdto fatherdto = null;
		if (optional.isPresent()) {
			Father father = optional.get();
			fatherdto = mapper.EntityTodto(father);
		} else {
			throw new RuntimeException("This id don't exist!");
		}
		return fatherdto;
	}
	@Override
	public List<Fatherdto> listOfFathers() {
		List<Father> fathers = fatherRepo.findAll();
		List<Fatherdto> fatherdtos = new ArrayList<>();
		for (Father father : fathers) {
			Fatherdto fatherdto = mapper.EntityTodto(father);
			fatherdtos.add(fatherdto);
		}
		return fatherdtos;
	}
	@Override
	public Fatherdto updateFather(int id, Fatherdto fatherdto) {
		Optional<Father> optional = fatherRepo.findById(id);
		Fatherdto fatherdto1 = null;
		if(optional.isPresent()){
			Father father = optional.get();
			father.setBirthDay(LocalDate.parse(fatherdto.getBirthDay()));
			father.setBirthPlace(fatherdto.getBirthPlace());
			father.setEmail(fatherdto.getEmail());
			father.setFirstName(fatherdto.getFirstName());
			father.setLastName(fatherdto.getLastName());
			father.setPassword(fatherdto.getPassword());
			father.setRole(fatherdto.getRole());
			fatherdto1 = mapper.EntityTodto(father);
			fatherRepo.save(father);
		}
		return fatherdto1;
	}
	@Override
	public void deleteFather(int id) {
		fatherRepo.deleteById(id);
	}
	
}
