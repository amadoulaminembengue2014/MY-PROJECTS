package com.vlm.cityhall.repository;

import com.vlm.cityhall.model.Mother;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotherRepo extends JpaRepository<Mother, Integer> {
}
