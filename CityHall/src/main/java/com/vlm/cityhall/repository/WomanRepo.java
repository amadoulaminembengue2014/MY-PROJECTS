package com.vlm.cityhall.repository;

import com.vlm.cityhall.model.Woman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WomanRepo extends JpaRepository<Woman, Integer> {
}
