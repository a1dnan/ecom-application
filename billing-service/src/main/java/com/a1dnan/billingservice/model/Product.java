package com.a1dnan.billingservice.model;

import lombok.Data;

@Data
public class Product {

    private Long id;
    private String name;
    private double price;
    private int quantity;
}
