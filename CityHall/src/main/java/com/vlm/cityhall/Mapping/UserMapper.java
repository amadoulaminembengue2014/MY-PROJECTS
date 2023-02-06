package com.vlm.cityhall.Mapping;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.vlm.cityhall.ENTITY.User;
import com.vlm.cityhall.model.Father;
import com.vlm.cityhall.model.Man;
import com.vlm.cityhall.model.Mother;
import com.vlm.cityhall.model.Woman;
import com.vlm.cityhall.wrapper.Fatherdto;
import com.vlm.cityhall.wrapper.Mandto;
import com.vlm.cityhall.wrapper.Motherdto;
import com.vlm.cityhall.wrapper.Parentdto;
import com.vlm.cityhall.wrapper.UserWrapper;
import com.vlm.cityhall.wrapper.Womandto;

@Component
public class UserMapper {
	
	public User dtoToEntity(UserWrapper userWrapper) {
		User user = new User();
		user.setBirthDay(LocalDate.parse(userWrapper.getBirthDay()));
		user.setBirthPlace(userWrapper.getBirthPlace());
		user.setEmail(userWrapper.getEmail());
		user.setFirstName(userWrapper.getFirstName());
		user.setLastName(userWrapper.getLastName());
		user.setPassword(userWrapper.getPassword());
		user.setStatus(userWrapper.getStatus());
		user.setRole(userWrapper.getRole());
		user.setTel(userWrapper.getTel());
		return user;
	}
	
	public UserWrapper EntityTodto(User user) {
		UserWrapper userWrapper = new UserWrapper();
		userWrapper.setId(user.getId());
		userWrapper.setBirthDay(user.getBirthDay().toString());
		userWrapper.setBirthPlace(user.getBirthPlace());
		userWrapper.setEmail(user.getEmail());
		userWrapper.setFirstName(user.getFirstName());
		userWrapper.setLastName(user.getLastName());
		userWrapper.setPassword(user.getPassword());
		userWrapper.setStatus(user.getStatus());
		userWrapper.setRole(user.getRole());
		userWrapper.setTel(user.getTel());
		return userWrapper;
	}
//Woman convert----------------------------------------
	public Woman dtoToEntity(Womandto womandto) {
		Woman woman = new Woman();
		woman.setBirthDay(LocalDate.parse(womandto.getBirthDay()));
		woman.setBirthPlace(womandto.getBirthPlace());
		woman.setEmail(womandto.getEmail());
		woman.setFirstName(womandto.getFirstName());
		woman.setLastName(womandto.getLastName());
		woman.setPassword(womandto.getPassword());
		woman.setRole(womandto.getRole());
		woman.setTel(womandto.getTel());
		woman.setStatus(womandto.getStatus());
		woman.setWedding(womandto.getWedding());
		return woman;
	}
	
	public Womandto EntityTodto(Woman woman) {
		Womandto womandto = new Womandto();
		womandto.setId(woman.getId());
		womandto.setBirthDay(woman.getBirthDay().toString());
		womandto.setBirthPlace(woman.getBirthPlace());
		womandto.setEmail(woman.getEmail());
		womandto.setFirstName(woman.getFirstName());
		womandto.setLastName(woman.getLastName());
		womandto.setPassword(woman.getPassword());
		womandto.setRole(woman.getRole());
		womandto.setTel(woman.getTel());
		woman.setStatus(womandto.getStatus());
		womandto.setWedding(woman.getWedding());
		return womandto;
	}
//Man convert---------------------------------------------
	public Man dtoToEntity(Mandto mandto) {
		Man man = new Man();
		man.setBirthDay(LocalDate.parse(mandto.getBirthDay()));
		man.setBirthPlace(mandto.getBirthPlace());
		man.setEmail(mandto.getEmail());
		man.setFirstName(mandto.getFirstName());
		man.setLastName(mandto.getLastName());
		man.setPassword(mandto.getPassword());
		man.setRole(mandto.getRole());
		man.setTel(mandto.getTel());
		man.setStatus(mandto.getStatus());
		man.setWedding(mandto.getWedding());
		return man;
	}
	
	public Mandto EntityTodto(Man man) {
		Mandto mandto = new Mandto();
		mandto.setId(man.getId());
		mandto.setBirthDay(man.getBirthDay().toString());
		mandto.setBirthPlace(man.getBirthPlace());
		mandto.setEmail(man.getEmail());
		mandto.setFirstName(man.getFirstName());
		mandto.setLastName(man.getLastName());
		mandto.setPassword(man.getPassword());
		mandto.setRole(man.getRole());
		mandto.setTel(man.getTel());
		mandto.setStatus(man.getTel());
		mandto.setWedding(man.getWedding());
		mandto.setTel(man.getTel());
		return mandto;
	}
//parent convert------------------------------------------
//	public Parent dtoToEntity(Parentdto parentdto) {
//		Parent parent = new Parent();
//		parent.setBirthDay(LocalDate.parse(parentdto.getBirthDay()));
//		parent.setBirthPlace(parentdto.getBirthPlace());
//		parent.setEmail(parentdto.getEmail());
//		parent.setFirstName(parentdto.getFirstName());
//		parent.setLastName(parentdto.getLastName());
//		parent.setPassword(parentdto.getPassword());
//		parent.setRole(parentdto.getRole());
//		parent.setTel(parentdto.getTel());
//		parent.setStatus(parentdto.getStatus());
//		parent.setTel(parentdto.getTel());
//		return parent;
//	}
//	
//	public Parentdto EntityTodto(Parent parent) {
//		Parentdto parentdto = new Parentdto();
//		parentdto.setId(parent.getId());
//		parentdto.setBirthDay(parent.getBirthDay().toString());
//		parentdto.setBirthPlace(parent.getBirthPlace());
//		parentdto.setEmail(parent.getEmail());
//		parentdto.setFirstName(parent.getFirstName());
//		parentdto.setLastName(parent.getLastName());
//		parentdto.setPassword(parent.getPassword());
//		parentdto.setRole(parent.getRole());
//		parentdto.setTel(parent.getTel());
//		parentdto.setStatus(parent.getStatus());
//		return parentdto;
//	}
//Father convert-----------------------------------------
	public Father dtoToEntity(Fatherdto fatherdto) {
		Father father = new Father();
		father.setBirthDay(LocalDate.parse(fatherdto.getBirthDay()));
		father.setBirthPlace(fatherdto.getBirthPlace());
		father.setEmail(fatherdto.getEmail());
		father.setFirstName(fatherdto.getFirstName());
		father.setLastName(fatherdto.getLastName());
		father.setPassword(fatherdto.getPassword());
		father.setRole(fatherdto.getRole());
		father.setTel(fatherdto.getTel());
		father.setStatus(fatherdto.getStatus());
		return father;
	}
	
	public Fatherdto EntityTodto(Father father) {
		Fatherdto fatherdto = new Fatherdto();
		fatherdto.setId(father.getId());
		fatherdto.setBirthDay(father.getBirthDay().toString());
		fatherdto.setBirthPlace(father.getBirthPlace());
		fatherdto.setEmail(father.getEmail());
		fatherdto.setFirstName(father.getFirstName());
		fatherdto.setLastName(father.getLastName());
		fatherdto.setPassword(father.getPassword());
		fatherdto.setRole(father.getRole());
		fatherdto.setTel(father.getTel());
		fatherdto.setStatus(father.getStatus());
		return fatherdto;
	}
	//Mother convert-----------------------------------------
	public Mother dtoToEntity(Motherdto motherdto) {
		Mother mother = new Mother();
		mother.setBirthDay(LocalDate.parse(motherdto.getBirthDay()));
		mother.setBirthPlace(motherdto.getBirthPlace());
		mother.setEmail(motherdto.getEmail());
		mother.setFirstName(motherdto.getFirstName());
		mother.setLastName(motherdto.getLastName());
		mother.setPassword(motherdto.getPassword());
		mother.setRole(motherdto.getRole());
		mother.setTel(motherdto.getTel());
		mother.setStatus(motherdto.getStatus());
		return mother;
	}
	
	public Motherdto EntityTodto(Mother mother) {
		Motherdto motherdto = new Motherdto();
		motherdto.setId(mother.getId());
		motherdto.setBirthDay(mother.getBirthDay().toString());
		motherdto.setBirthPlace(mother.getBirthPlace());
		motherdto.setEmail(mother.getEmail());
		motherdto.setFirstName(mother.getFirstName());
		motherdto.setLastName(mother.getLastName());
		motherdto.setPassword(mother.getPassword());
		motherdto.setRole(mother.getRole());
		motherdto.setTel(mother.getTel());
		motherdto.setStatus(mother.getStatus());
		return motherdto;
	}
}
