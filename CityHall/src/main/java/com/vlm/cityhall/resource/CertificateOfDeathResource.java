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

import com.vlm.cityhall.Service.CertificateOfDeathService;
import com.vlm.cityhall.model.CertificateOfBirth;
import com.vlm.cityhall.model.CertificateOfDeath;
import com.vlm.cityhall.wrapper.CertificateOfDeathdto;

@RestController
@RequestMapping("/CertificateOfDeath")
public class CertificateOfDeathResource {
    @Autowired
    private CertificateOfDeathService certificateOfDeathService;
    @PostMapping()
    public CertificateOfDeathdto create(@RequestBody CertificateOfDeathdto certificateOfDeathdto) {
    	return certificateOfDeathService.createCertificateOfDeath(certificateOfDeathdto);
    }
    
    @PutMapping("/{id}")
    public CertificateOfDeathdto update(@RequestBody CertificateOfDeathdto certificateOfDeath, @PathVariable Long id) {
    	return certificateOfDeathService.updateCertificateOfDeath(id, certificateOfDeath);
    }
    
    @GetMapping("/{id}")
    public CertificateOfDeathdto getOneObject(@PathVariable Long id ) {
    	return certificateOfDeathService.getCertificateOfDeath(id);
    }
    
    @GetMapping()
    public List<CertificateOfDeathdto> retrieveAll() {
    	return certificateOfDeathService.listOfCerticateOfDeath();
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	certificateOfDeathService.deleteCertificateOfDeath(id);
    }
}
