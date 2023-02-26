package com.vlm.shop.RestImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.shop.Constents.ShopConstants;
import com.vlm.shop.Rest.BillRest;
import com.vlm.shop.Service.BillService;
import com.vlm.shop.Utils.ShopUtils;

@RestController
public class BillRestImpl implements BillRest {
	
	@Autowired
	BillService billService;

	@Override
	public ResponseEntity<String> generateReport(Map<String, Object> requestMap) {
		try {
			return billService.generateReport(requestMap);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return ShopUtils.getResponseEntity(ShopConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
