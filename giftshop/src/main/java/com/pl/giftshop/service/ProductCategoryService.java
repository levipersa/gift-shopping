package com.pl.giftshop.service;

import com.pl.giftshop.exceptions.NoProductCategoryFoundException;
import com.pl.giftshop.exceptions.NoUsersFoundExceptions;
import com.pl.giftshop.model.ProductCategory;
import com.pl.giftshop.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public Page<ProductCategory> findAll(Pageable pageable) {
        Page<ProductCategory> categoryPage = productCategoryRepository.findAll(pageable);
        if (categoryPage.getContent().isEmpty() || categoryPage.getContent() == null) {
            throw new NoProductCategoryFoundException("No Categories are present in the current list ");
        }
        return categoryPage;
    }

    public ProductCategory findById(Long id) {
        Optional<ProductCategory> productCategory = productCategoryRepository.findById(id);
        if (!productCategory.isPresent()) {
            throw new NoProductCategoryFoundException("Category with id: " + id + " was not found!");
        }
        return productCategory.get();
    }

    public ProductCategory create(ProductCategory productCategory){

        return productCategoryRepository.save(productCategory);
    }


}
