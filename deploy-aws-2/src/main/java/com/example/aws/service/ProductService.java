package com.example.aws.service;

import com.example.aws.exception.ProductNotFoundException;
import com.example.aws.entity.Product;
import com.example.aws.repository.ProductRepository;
import com.example.aws.service.interfaceservice.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            Product existingProduct = productRepository.getOne(id);
            existingProduct.setNameProduct(product.getNameProduct());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setType(product.getType());
            productRepository.save(existingProduct);
        } else {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
