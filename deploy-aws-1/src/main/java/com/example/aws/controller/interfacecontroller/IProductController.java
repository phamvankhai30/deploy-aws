package com.example.aws.controller.interfacecontroller;

import com.example.aws.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IProductController {
    ResponseEntity<List<Product>> getAllProduct();
    ResponseEntity<Optional<Product>> findProductById(Long id);
    ResponseEntity<Void> createProduct(Product product);
    ResponseEntity<Void> updateProduct(Long id, Product product);
    ResponseEntity<Void> deleteProduct(Long id);
}
