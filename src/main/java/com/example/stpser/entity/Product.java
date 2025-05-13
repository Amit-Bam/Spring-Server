package com.example.stpser.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id",nullable = false,unique = true)
    @Id
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "price",nullable = false)
    private double price;
    @Column(name = "quantity",nullable = false)
    private int quantity;
}
