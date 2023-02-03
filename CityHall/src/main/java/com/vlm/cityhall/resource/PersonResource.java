package com.vlm.cityhall.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.cityhall.Service.PersonService;


@RestController
@RequestMapping("/person")
public class PersonResource {
	@Autowired
	private PersonService personService;
}
