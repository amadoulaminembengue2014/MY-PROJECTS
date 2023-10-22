package com.kangamit.gestionstockbackend.features.supplier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kangamit.gestionstockbackend.features.supplier.entity.Supplier;
import com.kangamit.gestionstockbackend.features.supplier.service.SupplierService;

@Controller
@RestController
@RequestMapping(path = "/supplier")
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@PostMapping("/createSupplier")
	public Supplier save(@RequestBody Supplier supplier) {
		return supplierService.create(supplier);
	}
	
	@GetMapping("/listSupplier")
	public List<Supplier> findAllSupplier() {
		return supplierService.ListOfSupplier();
	}
	
	@GetMapping("/getSupplier/{id}")
	public Supplier getOne(@PathVariable Long id) {
		return supplierService.getSupplier(id);
	}
	
	@PutMapping("/updateSupplier/{id}")
	public Supplier update(@RequestBody Supplier supplier, @PathVariable Long id) {
		return supplierService.updateSupplier(supplier, id);
	}
	
	@DeleteMapping("/deleteSupplier/{id}")
	void delete(@PathVariable Long id) {
		supplierService.deleteSuplier(id);
	}

}
