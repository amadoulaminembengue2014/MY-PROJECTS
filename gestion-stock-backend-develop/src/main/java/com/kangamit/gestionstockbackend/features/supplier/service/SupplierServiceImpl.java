package com.kangamit.gestionstockbackend.features.supplier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kangamit.gestionstockbackend.features.supplier.entity.Supplier;
import com.kangamit.gestionstockbackend.features.supplier.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public Supplier create(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public List<Supplier> ListOfSupplier() {
		return supplierRepository.findAll();
	}

	@Override
	public Supplier getSupplier(Long id) {
		return supplierRepository.findById(id).get();
	}

	@Override
	public Supplier updateSupplier(Supplier supplier, Long id) {
		supplier = supplierRepository.findById(id).get();
		return supplierRepository.save(supplier);
	}

	@Override
	public void deleteSuplier(Long id) {
		supplierRepository.deleteById(id);
	}

}
