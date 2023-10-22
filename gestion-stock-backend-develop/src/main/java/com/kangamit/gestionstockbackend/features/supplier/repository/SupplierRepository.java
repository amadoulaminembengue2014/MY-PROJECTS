package com.kangamit.gestionstockbackend.features.supplier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kangamit.gestionstockbackend.features.supplier.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
