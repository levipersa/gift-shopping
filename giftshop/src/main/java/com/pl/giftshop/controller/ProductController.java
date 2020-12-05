package com.pl.giftshop.controller;

import com.pl.giftshop.model.Product;
import com.pl.giftshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/all-product")
    public ResponseEntity<List<Product>> getProduct() {

        return ResponseEntity.ok(productRepository.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.of(productRepository.findById(id));
    }

    @PostMapping("/create-product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {

        productRepository.save(product);
        return ResponseEntity.ok(product);
    }


}
