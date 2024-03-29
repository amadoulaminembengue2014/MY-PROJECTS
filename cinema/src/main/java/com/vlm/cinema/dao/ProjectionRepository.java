package com.vlm.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vlm.cinema.entities.Projection;

@RepositoryRestResource
public interface ProjectionRepository extends JpaRepository<Projection, Long> {

}
