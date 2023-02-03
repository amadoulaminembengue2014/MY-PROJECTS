package com.vlm.cityhall.serviceRepo;

import java.util.List;

import com.vlm.cityhall.model.Wedding;
import com.vlm.cityhall.wrapper.Weddingdto;

public interface WeddingServiceRepo {
	Weddingdto ceateWedding(Weddingdto wedding);
	Weddingdto getWedding(Long id);
	List<Weddingdto> listOfWedding();
	Weddingdto updateWedding(Long id, Weddingdto wedding);
	void deleteWedding(Long id);
}
