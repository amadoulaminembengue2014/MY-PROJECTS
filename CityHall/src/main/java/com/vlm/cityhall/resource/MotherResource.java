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

import com.vlm.cityhall.Service.MotherService;
import com.vlm.cityhall.model.CertificateOfBirth;
import com.vlm.cityhall.wrapper.Fatherdto;
import com.vlm.cityhall.wrapper.Motherdto;

@RestController
@RequestMapping("/mother")
public class MotherResource {
	@Autowired
	private MotherService motherService;
	@PostMapping()
    public Motherdto create(@RequestBody Motherdto motherdto) {
    	return motherService.saveMother(motherdto);
    }
    
    @PutMapping("/{id}")
    public Motherdto update(@RequestBody Motherdto motherdto, @PathVariable int id) {
    	return motherService.updateMother(id, motherdto);
    }
    
    @GetMapping("/{id}")
    public Motherdto getOneObject(@PathVariable int id ) {
    	return motherService.getMother(id);
    }
    
    @GetMapping("/list")
    public List<Motherdto> retrieveAll() {
    	return motherService.listOfMothers();
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
    	motherService.deleteMother(id);
    }
}
