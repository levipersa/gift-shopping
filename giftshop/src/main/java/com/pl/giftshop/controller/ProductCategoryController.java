package com.pl.giftshop.controller;

import com.pl.giftshop.dto.ProductCategoryDto;
import com.pl.giftshop.dto.ProductDto;
import com.pl.giftshop.model.Product;
import com.pl.giftshop.model.ProductCategory;
import com.pl.giftshop.repository.ProductCategoryRepository;
import com.pl.giftshop.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/category")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryDto> getProductCategory(@PathVariable Long id) {

        ProductCategory productCategory = productCategoryService.findById(id);
        ProductCategoryDto productCategoryDto = new ProductCategoryDto();
        productCategoryDto.setId(productCategory.getId());
        productCategoryDto.setCategoryName(productCategory.getCategoryName());
        Set<ProductDto> productDtos = new HashSet<>();

        for (Product p : productCategory.getProducts()) {
            ProductDto productDto = new ProductDto(p.getId(), p.getName(), p.getDescription(), p.getUnitPrice(), p.getImageUrl(), p.getUnitsInStock());
            productDtos.add(productDto);
        }
        productCategoryDto.setProducts(productDtos);

        return ResponseEntity.ok(productCategoryDto);

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/create-category")
    public ResponseEntity<ProductCategory> createProductCategory(@RequestBody ProductCategory productCategory) {

        return ResponseEntity.ok(productCategoryService.create(productCategory));
    }
}
