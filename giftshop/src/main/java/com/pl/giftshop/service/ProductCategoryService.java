package com.pl.giftshop.service;

import com.pl.giftshop.exceptions.NoProductCategoryFoundException;
import com.pl.giftshop.exceptions.NoUsersFoundExceptions;
import com.pl.giftshop.model.Product;
import com.pl.giftshop.model.ProductCategory;
import com.pl.giftshop.repository.ProductCategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {

    private ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<ProductCategory> categoryPage = productCategoryRepository.findAll(pageable);
        if (categoryPage.getContent().isEmpty() || categoryPage.getContent() == null) {
            throw new NoProductCategoryFoundException("No Categories are present in the current list ");
        }
        return categoryPage.getContent();
    }

    public ProductCategory findById(Long id) {
        Optional<ProductCategory> productCategory = productCategoryRepository.findById(id);
        if (!productCategory.isPresent()) {
            throw new NoUsersFoundExceptions("Product with id: " + id + " was not found!");
        }
        return productCategory.get();
    }

    public ProductCategory create(ProductCategory productCategory){

        return productCategoryRepository.save(productCategory);
    }


}
