package com.vlm.cityhall.serviceRepo;

import java.util.List;

import com.vlm.cityhall.model.CertificateOfDeath;
import com.vlm.cityhall.wrapper.CertificateOfDeathdto;

public interface CertificateOfDeathServiceRepo {
	CertificateOfDeathdto createCertificateOfDeath(CertificateOfDeathdto certificateOfDeath);
	CertificateOfDeathdto getCertificateOfDeath(Long id);
	List<CertificateOfDeathdto> listOfCerticateOfDeath();
	CertificateOfDeathdto updateCertificateOfDeath (Long id, CertificateOfDeathdto certificateOfDeathdto);
	void deleteCertificateOfDeath(Long id);
}
