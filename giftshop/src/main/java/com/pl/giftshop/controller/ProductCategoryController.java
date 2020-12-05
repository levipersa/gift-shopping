package com.pl.giftshop.controller;

import com.pl.giftshop.model.ProductCategory;
import com.pl.giftshop.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @GetMapping("/all-category")
    public ResponseEntity<List<ProductCategory>> getProductCategory() {

        return ResponseEntity.ok(productCategoryRepository.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> getProductCategory(@PathVariable Long id) {
        return ResponseEntity.of(productCategoryRepository.findById(id));
    }

    @PostMapping("/create-category")
    public ResponseEntity<ProductCategory> createProductCategory(@RequestBody ProductCategory productCategory) {

        productCategoryRepository.save(productCategory);
        return ResponseEntity.ok(productCategory);
    }




}
