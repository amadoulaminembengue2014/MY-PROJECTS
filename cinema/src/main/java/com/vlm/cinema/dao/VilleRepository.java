package com.vlm.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vlm.cinema.entities.Ville;

@RepositoryRestResource
public interface VilleRepository extends JpaRepository<Ville, Long> {

}
