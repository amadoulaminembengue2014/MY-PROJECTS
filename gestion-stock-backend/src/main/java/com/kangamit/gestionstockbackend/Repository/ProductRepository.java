package com.kangamit.gestionstockbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kangamit.gestionstockbackend.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
