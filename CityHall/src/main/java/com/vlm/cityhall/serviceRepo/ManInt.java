package com.vlm.cityhall.serviceRepo;

import java.util.List;

import com.vlm.cityhall.model.Man;
import com.vlm.cityhall.wrapper.Mandto;

public interface ManInt {
	Mandto createMan(Mandto man);
	Mandto getMan(int id);
	List<Mandto> listOfMan();
	Mandto updateMan(int id, Mandto man);
	void deleteMan(int id);
}
