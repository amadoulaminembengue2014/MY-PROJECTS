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

import com.vlm.cityhall.Service.WeddingService;
import com.vlm.cityhall.model.CertificateOfBirth;
import com.vlm.cityhall.wrapper.Weddingdto;

@RestController
@RequestMapping("/Wedding")
public class WeddingResource {
    @Autowired
    private WeddingService weddingService;
    @PostMapping()
    public Weddingdto create(@RequestBody Weddingdto weddingdto) {
    	return weddingService.ceateWedding(weddingdto);
    }
    
    @PutMapping("/{id}")
    public Weddingdto update(@RequestBody Weddingdto weddingdto, @PathVariable Long id) {
    	return weddingService.updateWedding(id, weddingdto);
    }
    
    @GetMapping("/{id}")
    public Weddingdto getOneObject(@PathVariable Long id ) {
    	return weddingService.getWedding(id);
    }
    
    @GetMapping()
    public List<Weddingdto> retrieveAll() {
    	return weddingService.listOfWedding();
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	weddingService.deleteWedding(id);
    }
}
