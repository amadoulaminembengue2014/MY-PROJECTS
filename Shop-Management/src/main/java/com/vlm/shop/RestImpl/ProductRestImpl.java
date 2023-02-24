package com.vlm.shop.RestImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.shop.Constents.ShopConstants;
import com.vlm.shop.Rest.ProductRest;
import com.vlm.shop.Service.ProductService;
import com.vlm.shop.Utils.ShopUtils;
import com.vlm.shop.Wrapper.ProductWrapper;

@RestController
public class ProductRestImpl implements ProductRest {
	
	@Autowired
	ProductService productService;

	@Override
	public ResponseEntity<String> addNewProduct(Map<String, String> requestMap) {
		try {
			return productService.addNewProduct(requestMap);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return ShopUtils.getResponseEntity(ShopConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

	@Override
	public ResponseEntity<List<ProductWrapper>> getAllProduct() {
		try {
			return productService.getAllProduct();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}



	@Override
	public ResponseEntity<String> updateProduct(Map<String, String> requestMap) {
		try {
			return productService.updateProduct(requestMap);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ShopUtils.getResponseEntity(ShopConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}



	@Override
	public ResponseEntity<String> deleteProduct(Integer id) {
		try {
			return productService.deleteProduct(id);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return ShopUtils.getResponseEntity(ShopConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
