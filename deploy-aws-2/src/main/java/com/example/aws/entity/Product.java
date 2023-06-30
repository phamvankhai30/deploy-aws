package com.example.aws.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProduct;

    @Column(name = "name_product", nullable = false, columnDefinition = "VARCHAR(255)")
    private String nameProduct;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "type", nullable = false, columnDefinition = "VARCHAR(255)")
    private String type;
}

