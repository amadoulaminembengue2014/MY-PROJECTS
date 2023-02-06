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

import com.vlm.cityhall.Service.WomanService;
import com.vlm.cityhall.wrapper.Womandto;

@RestController
@RequestMapping("/woman")
public class WomanResource {
	@Autowired 
	private WomanService service;
	@PostMapping()
    public Womandto create(@RequestBody Womandto womandto) {
    	return service.saveUser(womandto);
    }
    
    @PutMapping("/{id}")
    public Womandto update(@RequestBody Womandto womandto, @PathVariable int id) {
    	return service.updateUser(id, womandto);
    }
    
    @GetMapping("/{id}")
    public Womandto getOneObject(@PathVariable int id ) {
    	return service.getUser(id);
    }
    
    @GetMapping()
    public List<Womandto> retrieveAll() {
    	return service.listOfUserWrappers();
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
    	service.deleteUser(id);
    }
}
