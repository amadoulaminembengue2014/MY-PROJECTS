package com.vlm.cityhall.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.cityhall.Service.CertificateOfBirthService;

@RestController
@RequestMapping("/CertificateOfBirth")
@CrossOrigin(origins= "http://localhost:4200")
public class CertificateOfBirthResource {
    @Autowired
    private CertificateOfBirthService birthService;
}
