package com.vlm.cityhall.Mapping;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.vlm.cityhall.ENTITY.User;
import com.vlm.cityhall.model.CertificateOfDeath;
import com.vlm.cityhall.wrapper.CertificateOfDeathdto;
import com.vlm.cityhall.wrapper.UserWrapper;

@Component
public class CertificateOfDeathMapper {
	
	public CertificateOfDeath dtoToEntity(CertificateOfDeathdto certificateOfDeathdto) {
		CertificateOfDeath certificateOfDeath = new CertificateOfDeath();
		certificateOfDeath.setCause_of_death(certificateOfDeathdto.getCause_of_death());
		certificateOfDeath.setDate_of_death(LocalDate.parse(certificateOfDeathdto.getDate_of_death()));
		certificateOfDeath.setId(certificateOfDeathdto.getId());
		return certificateOfDeath;
	}
	
	public CertificateOfDeathdto entityTodto(CertificateOfDeath certificateOfDeath) {
		CertificateOfDeathdto certificateOfDeathdto = new CertificateOfDeathdto();
		certificateOfDeathdto.setCause_of_death(certificateOfDeath.getCause_of_death());
		certificateOfDeathdto.setDate_of_death(certificateOfDeath.getDate_of_death().toString());
		certificateOfDeathdto.setId(certificateOfDeath.getId());
		return certificateOfDeathdto;
	}
}
