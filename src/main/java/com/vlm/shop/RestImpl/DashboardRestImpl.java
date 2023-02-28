package com.vlm.shop.RestImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.shop.Rest.DashboardRest;
import com.vlm.shop.Service.DashboardService;

@RestController
public class DashboardRestImpl implements DashboardRest {
	
	@Autowired
	DashboardService dashboardService;

	@Override
	public ResponseEntity<Map<String, Object>> getCount() {
		return dashboardService.getCount();
	}

	

}
