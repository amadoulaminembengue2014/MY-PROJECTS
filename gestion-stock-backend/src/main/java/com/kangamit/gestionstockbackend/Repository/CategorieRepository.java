package com.kangamit.gestionstockbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kangamit.gestionstockbackend.Entity.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
