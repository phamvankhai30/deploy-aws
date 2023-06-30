package com.example.aws.service.interfaceservice;

import com.example.aws.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> getAllProduct();
    Optional<Product> findProductById(Long id);
    void createProduct(Product product);
    void updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
