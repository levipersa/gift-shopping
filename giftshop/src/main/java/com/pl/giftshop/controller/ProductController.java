package com.pl.giftshop.controller;

import com.pl.giftshop.model.Product;
import com.pl.giftshop.repository.ProductRepository;
import com.pl.giftshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/all-product")
    public Page<Product> getProduct(Pageable pageable) {
        return  productService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping("/create-product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {

        return ResponseEntity.ok(productService.create(product));
    }


}
