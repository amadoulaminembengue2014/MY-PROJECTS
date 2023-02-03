package com.vlm.cityhall.repository;

import com.vlm.cityhall.model.CertificateOfBirth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateOfBirthRepo extends JpaRepository<CertificateOfBirth, Long> {
}
