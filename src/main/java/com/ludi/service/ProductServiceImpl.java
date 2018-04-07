package com.ludi.service;

import com.ludi.domain.Product;
import com.ludi.repository.ManufacturerRepository;
import com.ludi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    ManufacturerRepository manufacturerRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ManufacturerRepository manufacturerRepository) {
        this.productRepository = productRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    public Iterable<Product> list() {
        return productRepository.findAll();
    }

    @Transactional
    public Product create(Product product) {
        manufacturerRepository.save(product.getManufacturer());
        return productRepository.save(product);
    }

    public Product read(long id) {
        return productRepository.findOne(id);
    }

    public Product update(long id, Product updatedProduct) {
        Product product = productRepository.findOne(id);
        if(updatedProduct.getName() == null){
            product.setName((updatedProduct.getName()));
        }
        return productRepository.save(product);
    }

    public void delete(long id) {
        productRepository.delete(id);
    }
}
