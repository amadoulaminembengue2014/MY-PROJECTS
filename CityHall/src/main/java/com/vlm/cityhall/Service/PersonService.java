package com.vlm.cityhall.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlm.cityhall.DAO.UserDao;
import com.vlm.cityhall.ENTITY.User;
import com.vlm.cityhall.Mapping.UserMapper;
import com.vlm.cityhall.serviceRepo.UserService;
import com.vlm.cityhall.wrapper.UserWrapper;

@Service
public class PersonService implements UserService{
	@Autowired
	private UserMapper mapper;
	@Autowired
	private UserDao dao;
	@Override
	public UserWrapper saveUser(UserWrapper userWrapper) {
		User user = mapper.dtoToEntity(userWrapper);
		dao.save(user);
		return mapper.EntityTodto(user);
	}

	@Override
	public UserWrapper getUser(int id) {
		Optional<User> optional = dao.findById(id);
		UserWrapper userWrapper = null;
		if (optional.isPresent()) {
			User user = optional.get();
			userWrapper = mapper.EntityTodto(user);
		} else {
			throw new RuntimeException("This id don't exist !");
		}
		return userWrapper;
	}

	@Override
	public List<UserWrapper> listOfUserWrappers() {
		List<User> users = dao.findAll();
		List<UserWrapper> userWrappers = new ArrayList<>();
		for (User user : users) {
			UserWrapper userWrapper = mapper.EntityTodto(user);
			userWrappers.add(userWrapper);
		}
		return userWrappers;
	}

	@Override
	public UserWrapper updateUser(int id, UserWrapper userWrapper) {
		Optional<User> optional = dao.findById(id);
		UserWrapper userWrapper2 = null;
		if(optional.isPresent()) {
			User user = optional.get();
			user.setBirthDay(LocalDate.parse(userWrapper.getBirthDay()));
			user.setBirthPlace(userWrapper.getBirthPlace());
			user.setEmail(userWrapper.getEmail());
			user.setFirstName(userWrapper.getFirstName());
			user.setLastName(userWrapper.getLastName());
			user.setPassword(userWrapper.getPassword());
			user.setRole(userWrapper.getRole());
			dao.save(user);
			userWrapper2 = mapper.EntityTodto(user);
		}
		return userWrapper2;
	}

	@Override
	public void deleteUser(int id) {
		dao.deleteById(id);
	}
}
