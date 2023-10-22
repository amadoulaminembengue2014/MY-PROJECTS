package com.kangamit.gestionstockbackend.features.supplier.service;

import java.util.List;

import com.kangamit.gestionstockbackend.features.supplier.entity.Supplier;

public interface SupplierService {
	
	Supplier create(Supplier supplier);
	
	List<Supplier> ListOfSupplier();
	
	Supplier getSupplier(Long id);
	
	Supplier updateSupplier(Supplier supplier, Long id);
	
	void deleteSuplier(Long id);

}
