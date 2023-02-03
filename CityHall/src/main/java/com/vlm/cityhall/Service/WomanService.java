package com.vlm.cityhall.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlm.cityhall.Mapping.UserMapper;
import com.vlm.cityhall.model.Woman;
import com.vlm.cityhall.repository.WomanRepo;
import com.vlm.cityhall.serviceRepo.WomanInt;
import com.vlm.cityhall.wrapper.UserWrapper;
import com.vlm.cityhall.wrapper.Womandto;

@Service
public class WomanService implements WomanInt{
	@Autowired
	private WomanRepo repo;
	@Autowired
	private UserMapper mapper;
	@Override
	public Womandto saveUser(Womandto womandto) {
		Woman woman = new Woman();
		woman =  mapper.dtoToEntity(womandto);
		repo.save(woman);
		return mapper.EntityTodto(woman);
	}

	@Override
	public Womandto getUser(int id) {
		Optional<Woman> optional = repo.findById(id);
		Womandto womandto = null;
		if(optional.isPresent()) {
			womandto = mapper.EntityTodto(optional.get());
		}else {
			throw new RuntimeException("this id don't exist");
		}
		return womandto;
	}

	@Override
	public List<Womandto> listOfUserWrappers() {
		List<Woman> womans = repo.findAll();
		List<Womandto> womandtos = new ArrayList<>();
		for (Woman woman : womans) {
			Womandto womandto = mapper.EntityTodto(woman);
			womandtos.add(womandto);
		}
		return womandtos;
	}

	@Override
	public Womandto updateUser(int id, Womandto womandto) {
		Optional<Woman> optional = repo.findById(id);
		Womandto womandto2 = null;
		if(optional.isPresent()) {
			Woman woman = optional.get();
			woman.setBirthDay(LocalDate.parse(womandto.getBirthDay()));
			woman.setBirthPlace(womandto.getBirthPlace());
			woman.setEmail(womandto.getEmail());
			woman.setFirstName(womandto.getFirstName());
			woman.setLastName(womandto.getLastName());
			woman.setPassword(womandto.getPassword());
			woman.setRole(womandto.getRole());
			repo.save(woman);
			womandto2 = mapper.EntityTodto(woman);
		}
		return womandto2;
	}

	@Override
	public void deleteUser(int id) {
		repo.deleteById(id);
	}

	
}
