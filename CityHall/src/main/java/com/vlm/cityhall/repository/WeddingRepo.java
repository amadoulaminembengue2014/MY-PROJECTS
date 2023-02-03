package com.vlm.cityhall.repository;

import com.vlm.cityhall.model.Wedding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeddingRepo extends JpaRepository<Wedding, Long> {
}
