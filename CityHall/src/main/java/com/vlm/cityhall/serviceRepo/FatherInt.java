package com.vlm.cityhall.serviceRepo;

import java.util.List;

import com.vlm.cityhall.model.Father;
import com.vlm.cityhall.wrapper.Fatherdto;

public interface FatherInt {
	Fatherdto saveFather(Fatherdto father);
	Fatherdto getFather(int id);
	List<Fatherdto> listOfFathers();
	Fatherdto updateFather(int id, Fatherdto fatherdto);
	void deleteFather(int id);
}
