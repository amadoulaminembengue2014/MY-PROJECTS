package com.vlm.cityhall.repository;

import com.vlm.cityhall.model.Man;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManRepo extends JpaRepository<Man, Integer> {
}
