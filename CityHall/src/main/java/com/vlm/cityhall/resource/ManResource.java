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

import com.vlm.cityhall.Service.ManService;
import com.vlm.cityhall.model.CertificateOfBirth;
import com.vlm.cityhall.wrapper.Fatherdto;
import com.vlm.cityhall.wrapper.Mandto;

@RestController
@RequestMapping("/man")
public class ManResource {
	@Autowired
	private ManService manService;
	@PostMapping()
    public Mandto create(@RequestBody Mandto Mandto) {
    	return manService.createMan(Mandto);
    }
    
    @PutMapping("/{id}")
    public Mandto update(@RequestBody Mandto Mandto, @PathVariable int id) {
    	return manService.updateMan(id, Mandto);
    }
    
    @GetMapping("/{id}")
    public Mandto getOneObject(@PathVariable int id ) {
    	return manService.getMan(id);
    }
    
    @GetMapping()
    public List<Mandto> retrieveAll() {
    	return manService.listOfMan();
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
    	manService.deleteMan(id);
    }
}
