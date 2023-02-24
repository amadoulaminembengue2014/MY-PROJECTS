package com.vlm.shop.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlm.shop.Entity.Product;
import com.vlm.shop.Wrapper.ProductWrapper;

public interface ProductDao extends JpaRepository<Product, Integer> {

	List<ProductWrapper> getAllProduct();

}
