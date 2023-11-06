package com.a1dnan.billingservice.web;

import com.a1dnan.billingservice.entities.Bill;
import com.a1dnan.billingservice.repository.BillRepository;
import com.a1dnan.billingservice.repository.ProductItemRepository;
import com.a1dnan.billingservice.services.CustomerRestClient;
import com.a1dnan.billingservice.services.ProductRestClient;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BillRestController {

    private final BillRepository billRepository;
    private final ProductItemRepository productItemRepository;
    private final ProductRestClient productRestClient;
    private final CustomerRestClient customerRestClient;

    @GetMapping("/fullBill/{id}")
    public Bill getBill(@PathVariable Long id){
        Bill bill = billRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Bill not found"));
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.findProductById(productItem.getProductId()));
        });
        return bill;
    }
}
