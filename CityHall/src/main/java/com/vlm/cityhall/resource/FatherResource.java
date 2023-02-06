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

import com.vlm.cityhall.Service.FatherService;
import com.vlm.cityhall.model.CertificateOfBirth;
import com.vlm.cityhall.wrapper.Fatherdto;

@RestController
@RequestMapping("/father")
public class FatherResource {
	@Autowired
	private FatherService fatherService;
	@PostMapping()
    public Fatherdto create(@RequestBody Fatherdto fatherdto) {
    	return fatherService.saveFather(fatherdto);
    }
    
    @PutMapping("/{id}")
    public Fatherdto update(@RequestBody Fatherdto fatherdto, @PathVariable int id) {
    	return fatherService.updateFather(id, fatherdto);
    }
    
    @GetMapping("/{id}")
    public Fatherdto getOneObject(@PathVariable int id ) {
    	return fatherService.getFather(id);
    }
    
    @GetMapping()
    public List<Fatherdto> retrieveAll() {
    	return fatherService.listOfFathers();
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
    	fatherService.deleteFather(id);
    }
}
