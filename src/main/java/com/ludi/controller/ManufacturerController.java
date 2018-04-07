package com.ludi.controller;

import com.ludi.domain.Manufacturer;
import com.ludi.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {

    ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerController(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @RequestMapping("/")
    public Iterable<Manufacturer> list() {
        return manufacturerRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Manufacturer read(@PathVariable(value = "id") long id){
        return manufacturerRepository.findOne(id);
    }
}
