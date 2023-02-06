package com.vlm.cityhall.repository;

import com.vlm.cityhall.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepo extends JpaRepository<Parent, Integer> {
}
