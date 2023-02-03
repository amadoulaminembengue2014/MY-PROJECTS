package com.vlm.cityhall.repository;

import com.vlm.cityhall.model.Father;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatherRepo extends JpaRepository <Father, Integer>{
}
