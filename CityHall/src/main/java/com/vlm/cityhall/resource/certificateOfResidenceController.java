package com.vlm.cityhall.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.cityhall.Service.CertificateOfResidenceService;
import com.vlm.cityhall.model.CertificateOfResidence;

@RestController
@RequestMapping("/certificateOfResidence")
@CrossOrigin(origins= "http://localhost:4200")
public class certificateOfResidenceController {
	
	@Autowired
	private CertificateOfResidenceService  certificateOfResidenceService;
	
	
	@PostMapping()
	public CertificateOfResidence save(@RequestBody CertificateOfResidence certificateOfResidence) {
		return certificateOfResidenceService.create(certificateOfResidence);
	}
	
	@GetMapping()
	public List<CertificateOfResidence> retrieveAll() {
		return certificateOfResidenceService.listeOfCertificateOfResidence();
	}
	
	@GetMapping("/{id}")
	public CertificateOfResidence getOne(@PathVariable Long id) {
		return certificateOfResidenceService.getCertificateOfResidence(id);
	}
	
	@PutMapping("/{id}")
	public CertificateOfResidence update(@RequestBody CertificateOfResidence certificateOfResidence, @PathVariable Long id) {
		return certificateOfResidenceService.UpdateCertificateOfResidence(certificateOfResidence, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCertificateOfResidence(@PathVariable Long id) {
		certificateOfResidenceService.delete(id);
	}
}
