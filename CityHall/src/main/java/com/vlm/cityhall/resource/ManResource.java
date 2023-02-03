package com.vlm.cityhall.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.cityhall.Service.ManService;

@RestController
@RequestMapping("/man")
public class ManResource {
	@Autowired
	private ManService manService;
}
