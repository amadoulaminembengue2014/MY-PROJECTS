package com.vlm.cityhall.repository;

import com.vlm.cityhall.model.CertificateOfDeath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateOfDeathRepo extends JpaRepository<CertificateOfDeath, Long> {
}
