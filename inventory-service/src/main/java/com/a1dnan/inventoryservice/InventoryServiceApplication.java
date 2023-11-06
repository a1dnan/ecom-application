package com.a1dnan.inventoryservice;

import com.a1dnan.inventoryservice.entities.Product;
import com.a1dnan.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){

        return args -> {
            restConfiguration.exposeIdsFor(Product.class);
            productRepository.saveAll(
                    List.of(
                            Product.builder()
                                    .name("Computer")
                                    .quantity(12)
                                    .price(8000)
                                    .build(),
                            Product.builder()
                                    .name("Mobile")
                                    .quantity(6)
                                    .price(5000)
                                    .build(),
                            Product.builder()
                                    .name("TV")
                                    .quantity(1)
                                    .price(10000)
                                    .build()

                    )
            );
            productRepository.findAll().forEach(customer -> {
                System.out.println(customer);
            });
        };
}
}
