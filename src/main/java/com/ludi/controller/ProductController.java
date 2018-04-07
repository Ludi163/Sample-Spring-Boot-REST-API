package com.ludi.controller;

import com.ludi.domain.Product;
import com.ludi.exception.ProductNotFoundException;
import com.ludi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Product> list() {
        return productService.list();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product read(@PathVariable(value = "id") long id) throws ProductNotFoundException {
        Product product = productService.read(id);
        if (product == null) {
            throw new ProductNotFoundException("Can't find product with ID: " + id + ".");
        }
        return product;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public void handleProductNotFound(ProductNotFoundException exception, HttpServletResponse response)
            throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Product update(@PathVariable(value = "id") long id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") long id){
        productService.delete(id);
    }
}
