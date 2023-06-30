package com.example.aws.controller;

import com.example.aws.controller.interfacecontroller.IProductController;
import com.example.aws.entity.Product;
import com.example.aws.service.interfaceservice.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController implements IProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/list")
    @Override
    public ResponseEntity<List<Product>> getAllProduct() {
        if (productService.getAllProduct().isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/list/by-id")
    @Override
    public ResponseEntity<Optional<Product>> findProductById(@RequestParam Long id) {
        Optional<Product> productById = productService.findProductById(id);
        if (productById.isPresent()){
            return ResponseEntity.ok(productById);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    @Override
    public ResponseEntity<Void> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update")
    @Override
    public ResponseEntity<Void> updateProduct(@RequestParam  Long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    @Override
    public ResponseEntity<Void> deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
