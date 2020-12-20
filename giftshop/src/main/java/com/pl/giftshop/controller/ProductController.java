package com.pl.giftshop.controller;

import com.pl.giftshop.dto.ProductDto;
import com.pl.giftshop.model.Product;
import com.pl.giftshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all-product")
    public List<ProductDto> getProduct(Pageable pageable) {

        List<Product> products = productService.findAll(pageable).toList();
        List<ProductDto> productDtos = new ArrayList<>();

        for (Product p : products) {
            ProductDto productDto = new ProductDto(p.getId(), p.getName(), p.getDescription(), p.getUnitPrice(), p.getImageUrl(), p.getUnitsInStock());
            productDtos.add(productDto);
        }
        
        return  productDtos;

    }

//    @CrossOrigin(origins = "http://localhost:4200")
//    @GetMapping("/category-product")
//    public List<Product> getProductByCategory (Long id, Pageable pageable) {
//        return productService.findByCategory(id,pageable).getContent();
//    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@RequestParam("id") Long id) {

        Product p = productService.findById(id);
        ProductDto productDto = new ProductDto(p.getId(), p.getName(), p.getDescription(), p.getUnitPrice(), p.getImageUrl(), p.getUnitsInStock());

        return ResponseEntity.ok(productDto);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/create-product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {

        return ResponseEntity.ok(productService.create(product));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/delete-product/{id}")
    public void deleteProduct(@PathVariable Long id) {

        productService.delete(id);

    }


}
