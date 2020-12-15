package com.pl.giftshop.controller;

import com.pl.giftshop.model.Product;
import com.pl.giftshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all-product")
    public List<Product> getProduct(Pageable pageable) {
        return  productService.findAll(pageable).getContent();
    }


    @GetMapping("/category-product")
    public Page<Product> getProductByCategory (Long id, Pageable pageable) {
        return productService.findByCategory(id,pageable);
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
