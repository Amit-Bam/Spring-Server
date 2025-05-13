package com.example.stpser.controller;

import com.example.stpser.entity.Product;
import com.example.stpser.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //create product
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    //get all products
    @GetMapping
    public List<Product> getALlProducts(){
        return productService.getALlProducts();
    }

    //get product by id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    //update product information
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
        return productService.updateProduct(id, productDetails);
    }

    //delete product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

}
