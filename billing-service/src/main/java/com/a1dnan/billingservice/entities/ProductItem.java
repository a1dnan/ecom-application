package com.a1dnan.billingservice.entities;

import com.a1dnan.billingservice.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    @ManyToOne
    private Bill bill;
    private int quantity;
    private double price;
    private double discount;
    @Transient
    private Product product;
}
