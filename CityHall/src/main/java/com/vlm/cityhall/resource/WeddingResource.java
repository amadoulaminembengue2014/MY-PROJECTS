package com.vlm.cityhall.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.cityhall.Service.WeddingService;

@RestController
@RequestMapping("/Wedding")
public class WeddingResource {
    @Autowired
    private WeddingService weddingService;
}
