package com.kangamit.gestionstockbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kangamit.gestionstockbackend.Entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
