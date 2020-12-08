package com.pl.giftshop.controller;

import com.pl.giftshop.model.ProductCategory;
import com.pl.giftshop.repository.ProductCategoryRepository;
import com.pl.giftshop.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class ProductCategoryController {


    @Autowired
    private ProductCategoryService productCategoryService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all-category")
    public Page<ProductCategory> getProductCategory(Pageable pageable) {

        return productCategoryService.findAll(pageable);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> getProductCategory(@PathVariable Long id) {
        return ResponseEntity.ok(productCategoryService.findById(id));
    }

    @PostMapping("/create-category")
    public ResponseEntity<ProductCategory> createProductCategory(@RequestBody ProductCategory productCategory) {

        return ResponseEntity.ok(productCategoryService.create(productCategory));
    }




}
