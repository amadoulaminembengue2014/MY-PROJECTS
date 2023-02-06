package com.vlm.cityhall.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.cityhall.Service.CertificateOfBirthService;
import com.vlm.cityhall.model.CertificateOfBirth;

@RestController
@RequestMapping("/CertificateOfBirth")
public class CertificateOfBirthResource {
    @Autowired
    private CertificateOfBirthService birthService;
    
    @PostMapping()
    public CertificateOfBirth create(@RequestBody CertificateOfBirth birth) {
    	return birthService.create(birth);
    }
    
    @PutMapping("/{id}")
    public CertificateOfBirth update(@RequestBody CertificateOfBirth birth, @PathVariable Long id) {
    	return birthService.updateCertificateOfBirth(id, birth);
    }
    
    @GetMapping("/{id}")
    public CertificateOfBirth getOneObject(@PathVariable Long id ) {
    	return birthService.getCertificateOfBirth(id);
    }
    
    @GetMapping()
    public List<CertificateOfBirth> retrieveAll() {
    	return birthService.listOfCertificate();
    }
    
    @DeleteMapping()
    public void delete(@PathVariable Long id) {
    	birthService.deleteCertificationOfbirth(id);
    }
}
