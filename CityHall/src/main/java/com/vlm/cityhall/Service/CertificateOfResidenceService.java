package com.vlm.cityhall.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlm.cityhall.model.CertificateOfResidence;
import com.vlm.cityhall.repository.CertificateOfResidenceRepo;
import com.vlm.cityhall.serviceRepo.CertificateOfResidenceServiceRepo;

@Service
public class CertificateOfResidenceService implements CertificateOfResidenceServiceRepo {
	
	@Autowired
	private CertificateOfResidenceRepo certificateOfResidenceRepo;
	
	
	@Override
	public CertificateOfResidence create(CertificateOfResidence certificateOfResidence) {
		return certificateOfResidenceRepo.save(certificateOfResidence);
	}

	@Override
	public List<CertificateOfResidence> listeOfCertificateOfResidence() {
		return certificateOfResidenceRepo.findAll();
	}

	@Override
	public CertificateOfResidence getCertificateOfResidence(Long id) {
		return certificateOfResidenceRepo.findById(id).get();
	}

	@Override
	public CertificateOfResidence UpdateCertificateOfResidence(CertificateOfResidence certificateOfResidence, Long id) {
		certificateOfResidence = certificateOfResidenceRepo.findById(id).get();
		return certificateOfResidenceRepo.save(certificateOfResidence);
	}

	@Override
	public void delete(Long id) {
		certificateOfResidenceRepo.deleteById(id);
	}

}
