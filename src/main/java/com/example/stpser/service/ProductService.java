package com.example.stpser.service;

import com.example.stpser.entity.Product;
import com.example.stpser.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    final private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product createProduct(Product product){
        return (Product) productRepository.save(product);
    }

    //get all products
    public List<Product> getALlProducts(){
        return productRepository.findAll();
    }

    //get product by id
    public Product getProductById(long id){
        Optional<Product> prod = productRepository.findById(id);
        if (prod.isEmpty()){
            return new Product();
        }
        return prod.get();
    }

    //update product information
    public String updateProduct(long id, Product productDetails){
        Optional<Product> prod = productRepository.findById(id);
        if (prod.isPresent()){
            Product product = prod.get();
            product.setName(productDetails.getName());
            product.setDescription(productDetails.getDescription());
            product.setPrice(productDetails.getPrice());
            product.setQuantity(productDetails.getQuantity());
            productRepository.save(product);
            return "Product Updated Successfully";
        }
        return "Product Not Found";
    }

    //delete product
    public void deleteProduct(long id){
        Optional<Product> prod = productRepository.findById(id);
        if (!prod.isEmpty()){
            productRepository.delete(prod.get());
        }
    }
}
