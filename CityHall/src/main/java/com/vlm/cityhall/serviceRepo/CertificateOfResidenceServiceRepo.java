package com.vlm.cityhall.serviceRepo;

import java.util.List;

import com.vlm.cityhall.model.CertificateOfResidence;

public interface CertificateOfResidenceServiceRepo {
	
	CertificateOfResidence create(CertificateOfResidence certificateOfResidence);
	
	List<CertificateOfResidence> listeOfCertificateOfResidence();
	
	CertificateOfResidence getCertificateOfResidence(Long id);
	
	CertificateOfResidence UpdateCertificateOfResidence(CertificateOfResidence certificateOfResidence, Long id );
	
	void delete(Long id);
}
