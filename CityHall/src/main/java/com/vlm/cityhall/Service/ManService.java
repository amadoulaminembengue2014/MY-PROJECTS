package com.vlm.cityhall.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlm.cityhall.Mapping.UserMapper;
import com.vlm.cityhall.model.Man;
import com.vlm.cityhall.repository.ManRepo;
import com.vlm.cityhall.serviceRepo.ManInt;
import com.vlm.cityhall.wrapper.Mandto;

@Service
public class ManService implements ManInt{
	@Autowired
	private UserMapper mapper;
	@Autowired
	private ManRepo manRepo;
	@Override
	public Mandto createMan(Mandto man) {
		Man man2 = mapper.dtoToEntity(man);
		manRepo.save(man2);
		return mapper.EntityTodto(man2);
	}
	@Override
	public Mandto getMan(int id) {
		Mandto mandto = null;
		if (manRepo.findById(id).isPresent()) {
			mandto = mapper.EntityTodto(manRepo.findById(id).get()); 
		} else {
			throw new RuntimeException("This id is not valid !");
		}
		return mandto;
	}
	@Override
	public List<Mandto> listOfMan() {
		List<Mandto> mandtos = new ArrayList<>();
		for (Man man : manRepo.findAll()) {
			Mandto  mandto = mapper.EntityTodto(man);
			mandtos.add(mandto);
		}
		return mandtos;
	}
	@Override
	public Mandto updateMan(int id, Mandto mandto) {
		Mandto mandto1 = null;
		if (manRepo.findById(id).isPresent()) {
			Man man = manRepo.findById(id).get();
			man.setBirthDay(LocalDate.parse(mandto.getBirthDay()));
			man.setBirthPlace(mandto.getBirthPlace());
			man.setEmail(mandto.getEmail());
			man.setFirstName(mandto.getFirstName());
			man.setLastName(mandto.getLastName());
			man.setPassword(mandto.getPassword());
			man.setRole(mandto.getRole());
			mandto1 = mapper.EntityTodto(man);
			manRepo.save(man);
		}
		return mandto1;
	}
	@Override
	public void deleteMan(int id) {
		manRepo.deleteById(id);
	}
	
}
