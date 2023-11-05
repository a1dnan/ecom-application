package com.a1dnan.customerservice;

import com.a1dnan.customerservice.entities.Customer;
import com.a1dnan.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RestControllerConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository){

        return args -> {
            customerRepository.saveAll(
                    List.of(
                            Customer.builder()
                                    .name("Adnan")
                                    .email("adnan@gmail.com")
                                    .build(),
                            Customer.builder()
                                    .name("Issam")
                                    .email("issam@gmail.com")
                                    .build(),
                            Customer.builder()
                                    .name("Mohamed")
                                    .email("med@gmail.com")
                                    .build()
                    )
            );
            customerRepository.findAll().forEach(customer -> {
                System.out.println(customer);
            });
        };
    }
}
