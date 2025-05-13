package com.example.stpser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.stpser.entity.Product;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByNameContaining(String name);
    List<Product> findByPriceLessThan(Double price);
}
