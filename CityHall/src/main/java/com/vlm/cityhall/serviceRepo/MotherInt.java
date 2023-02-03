package com.vlm.cityhall.serviceRepo;

import java.util.List;

import com.vlm.cityhall.model.Mother;
import com.vlm.cityhall.wrapper.Motherdto;

public interface MotherInt {
	Motherdto saveMother(Motherdto mother);
	Motherdto getMother(int id);
	List<Motherdto> listOfMothers();
	Motherdto updateMother(int id, Motherdto mother);
	void deleteMother(int id);
}
