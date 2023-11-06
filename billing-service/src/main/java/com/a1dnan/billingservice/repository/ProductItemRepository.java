package com.a1dnan.billingservice.repository;

import com.a1dnan.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
