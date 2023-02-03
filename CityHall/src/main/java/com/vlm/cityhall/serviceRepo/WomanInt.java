package com.vlm.cityhall.serviceRepo;

import java.util.List;

import com.vlm.cityhall.wrapper.UserWrapper;
import com.vlm.cityhall.wrapper.Womandto;

public interface WomanInt {
	Womandto saveUser(Womandto womandto);
	Womandto getUser(int id);
	List<Womandto> listOfUserWrappers();
	Womandto updateUser(int id, Womandto womandto);
	void deleteUser(int id);
}
