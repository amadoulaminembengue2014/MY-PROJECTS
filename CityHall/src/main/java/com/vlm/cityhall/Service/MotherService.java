package com.vlm.cityhall.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlm.cityhall.Mapping.UserMapper;
import com.vlm.cityhall.model.Mother;
import com.vlm.cityhall.repository.MotherRepo;
import com.vlm.cityhall.serviceRepo.MotherInt;
import com.vlm.cityhall.wrapper.Motherdto;

@Service
public class MotherService implements MotherInt{
	@Autowired
	private UserMapper mapper;
	@Autowired
	private MotherRepo motherRepo;
	@Override
	public Motherdto saveMother(Motherdto mother) {
		Mother mother2 = motherRepo.save(mapper.dtoToEntity(mother));
		return mapper.EntityTodto(mother2);
	}
	@Override
	public Motherdto getMother(int id) {
		Motherdto motherdto = null;
		if (motherRepo.findById(id).isPresent()) {
			motherdto = mapper.EntityTodto(motherRepo.findById(id).get());
		} else {
			throw new RuntimeException("Invalid id !");
		}
		return motherdto;
	}
	@Override
	public List<Motherdto> listOfMothers() {
		List<Motherdto> motherdtos = new ArrayList<>();
		for (Mother mother : motherRepo.findAll()) {
			Motherdto motherdto = mapper.EntityTodto(mother);
			motherdtos.add(motherdto);
		}
		return motherdtos;
	}
	@Override
	public Motherdto updateMother(int id, Motherdto motherdto) {
		Motherdto motherdto2 = null;
		if (motherRepo.findById(id).isPresent()) {
			Mother mother = motherRepo.findById(id).get();
			mother.setBirthDay(LocalDate.parse(motherdto.getBirthDay()));
			mother.setBirthPlace(motherdto.getBirthPlace());
			mother.setEmail(motherdto.getEmail());
			mother.setFirstName(motherdto.getFirstName());
			mother.setLastName(motherdto.getLastName());
			mother.setPassword(motherdto.getPassword());
			mother.setRole(motherdto.getRole());
			motherdto2 = mapper.EntityTodto(mother);
			motherRepo.save(mother);
		}
		return motherdto2;
	}
	@Override
	public void deleteMother(int id) {
		motherRepo.deleteById(id);		
	}
	
}
