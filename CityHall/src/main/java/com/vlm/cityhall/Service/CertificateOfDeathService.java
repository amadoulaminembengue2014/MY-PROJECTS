package com.vlm.cityhall.Service;

import com.vlm.cityhall.Mapping.CertificateOfDeathMapper;
import com.vlm.cityhall.Mapping.UserMapper;
import com.vlm.cityhall.model.CertificateOfDeath;
import com.vlm.cityhall.repository.CertificateOfDeathRepo;
import com.vlm.cityhall.serviceRepo.CertificateOfDeathServiceRepo;
import com.vlm.cityhall.wrapper.CertificateOfDeathdto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CertificateOfDeathService implements CertificateOfDeathServiceRepo {
	@Autowired
	private CertificateOfDeathMapper mapper;
	@Autowired
	private CertificateOfDeathRepo certificateOfDeathRepo;
	@Override
	public CertificateOfDeathdto createCertificateOfDeath(CertificateOfDeathdto certificateOfDeath) {
		CertificateOfDeath death = mapper.dtoToEntity(certificateOfDeath);
		certificateOfDeathRepo.save(death);
		return mapper.entityTodto(death);
	}

	@Override
	public CertificateOfDeathdto getCertificateOfDeath(Long id) {
		Optional<CertificateOfDeath> optional = certificateOfDeathRepo.findById(id);
		CertificateOfDeathdto certificateOfDeathdto = null;
		if (optional.isPresent()) {
			CertificateOfDeath certificateOfDeath = optional.get();
			certificateOfDeathdto = mapper.entityTodto(certificateOfDeath);
		} else {
			throw new RuntimeException("This id don;t exist !");
		}
		return certificateOfDeathdto;
	}

	@Override
	public List<CertificateOfDeathdto> listOfCerticateOfDeath() {
		List<CertificateOfDeath> certificateOfDeaths = certificateOfDeathRepo.findAll();
		List<CertificateOfDeathdto> certificateOfDeathdtos = new ArrayList<>();
		for (CertificateOfDeath certificateOfDeath : certificateOfDeaths) {
			CertificateOfDeathdto certificateOfDeathdto = mapper.entityTodto(certificateOfDeath);
			certificateOfDeathdtos.add(certificateOfDeathdto);
		}
		return certificateOfDeathdtos;
	}

	@Override
	public CertificateOfDeathdto updateCertificateOfDeath(Long id, CertificateOfDeathdto certificateOfDeathdto) {
		Optional<CertificateOfDeath> optional = certificateOfDeathRepo.findById(id);
		CertificateOfDeathdto deathdto = null;
		if(optional.isPresent()) {
			CertificateOfDeath certificateOfDeath = optional.get();
			certificateOfDeath.setCause_of_death(certificateOfDeathdto.getCause_of_death());
			certificateOfDeath.setDate_of_death(LocalDate.parse(certificateOfDeathdto.getDate_of_death()));
			certificateOfDeath.setId(certificateOfDeathdto.getId());
			certificateOfDeathRepo.save(certificateOfDeath);
			deathdto = mapper.entityTodto(certificateOfDeath);
		}
		return deathdto;
	}

	@Override
	public void deleteCertificateOfDeath(Long id) {
		certificateOfDeathRepo.deleteById(id);
	}
    
}
