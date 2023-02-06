package com.vlm.cityhall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlm.cityhall.model.CertificateOfResidence;
@Repository
public interface CertificateOfResidenceRepo extends JpaRepository<CertificateOfResidence, Long> {

}
