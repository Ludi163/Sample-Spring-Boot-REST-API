package com.ludi;

import com.ludi.domain.Manufacturer;
import com.ludi.domain.Product;
import com.ludi.repository.ManufacturerRepository;
import com.ludi.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@SpringBootApplication
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ManufacturerRepository manufacturerRepository, ProductRepository productRepository) {
        return args -> {

            Manufacturer manufacturer1 = new Manufacturer("Ludi S.A.", "Ludi's country");
            Manufacturer manufacturer2 = new Manufacturer("REST API","REST's country");

            manufacturerRepository.save(manufacturer1);
            manufacturerRepository.save(manufacturer2);

            Product soap = new Product("Soap", 5, new Date(), manufacturer1);
            Product juice = new Product("Orange juice", 2, new Date(), manufacturer1);
            productRepository.save(soap);
            productRepository.save(juice);

            Product chips = new Product("Healthy chips", 120, new Date(), manufacturer2);
            productRepository.save(chips);
        };
    }
}
