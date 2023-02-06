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

import com.vlm.cityhall.Service.PersonService;
import com.vlm.cityhall.model.CertificateOfBirth;
import com.vlm.cityhall.wrapper.Fatherdto;
import com.vlm.cityhall.wrapper.UserWrapper;


@RestController
@RequestMapping("/person")
public class PersonResource {
	@Autowired
	private PersonService personService;
	@PostMapping()
    public UserWrapper create(@RequestBody UserWrapper userWrapper) {
    	return personService.saveUser(userWrapper);
    }
    
    @PutMapping("/{id}")
    public UserWrapper update(@RequestBody UserWrapper userWrapper, @PathVariable int id) {
    	return personService.updateUser(id, userWrapper);
    }
    
    @GetMapping("/{id}")
    public UserWrapper getOneObject(@PathVariable int id ) {
    	return personService.getUser(id);
    }
    
    @GetMapping()
    public List<UserWrapper> retrieveAll() {
    	return personService.listOfUserWrappers();
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
    	personService.deleteUser(id);
    }
}
