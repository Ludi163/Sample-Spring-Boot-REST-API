package com.ludi.controller;

import com.ludi.domain.Manufacturer;
import com.ludi.exception.ManufacturerNotFoundException;
import com.ludi.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public Manufacturer read(@PathVariable(value = "id") long id) throws ManufacturerNotFoundException {
        Manufacturer manufacturer = manufacturerRepository.findOne(id);
        if (manufacturer == null) {
            throw new ManufacturerNotFoundException("Can't find manufacturer with ID: " + id + ".");
        }
        return manufacturer;
    }

    @ExceptionHandler(ManufacturerNotFoundException.class)
    public void handleManufacturerNotFound(ManufacturerNotFoundException exception, HttpServletResponse response)
            throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

}
