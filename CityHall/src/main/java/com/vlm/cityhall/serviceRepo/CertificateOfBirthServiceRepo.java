package com.vlm.cityhall.serviceRepo;

import java.util.List;

import com.vlm.cityhall.model.CertificateOfBirth;

public interface CertificateOfBirthServiceRepo {
	CertificateOfBirth create(CertificateOfBirth birth);
	List<CertificateOfBirth> listOfCertificate();
	CertificateOfBirth getCertificateOfBirth(Long id);
	CertificateOfBirth updateCertificateOfBirth(Long id, CertificateOfBirth birth);
	void deleteCertificationOfbirth(Long id);
}
