package com.vlm.cityhall.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlm.cityhall.model.CertificateOfBirth;
import com.vlm.cityhall.repository.CertificateOfBirthRepo;
import com.vlm.cityhall.serviceRepo.CertificateOfBirthServiceRepo;

@Service
public class CertificateOfBirthService implements CertificateOfBirthServiceRepo{
	@Autowired
	private CertificateOfBirthRepo birthServiceRepo;
	@Override
	public CertificateOfBirth create(CertificateOfBirth birth) {
		CertificateOfBirth birth2 = birthServiceRepo.save(birth);
		return birth2;
	}

	@Override
	public List<CertificateOfBirth> listOfCertificate() {
		return birthServiceRepo.findAll();
	}

	@Override
	public CertificateOfBirth getCertificateOfBirth(Long id) {
		return birthServiceRepo.findById(id).get();
	}

	@Override
	public CertificateOfBirth updateCertificateOfBirth(Long id, CertificateOfBirth birth) {
		Optional<CertificateOfBirth> optional = birthServiceRepo.findById(id);
		CertificateOfBirth birth2 = birthServiceRepo.save(optional.get());
		return birth2;
	}

	@Override
	public void deleteCertificationOfbirth(Long id) {
		birthServiceRepo.deleteById(id);
	}
    

}
