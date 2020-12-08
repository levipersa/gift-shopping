package com.pl.giftshop.service;

import com.pl.giftshop.exceptions.NoProductFoundExceptions;
import com.pl.giftshop.exceptions.NoUsersFoundExceptions;
import com.pl.giftshop.model.Product;
import com.pl.giftshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> findAll(Pageable pageable) {
        Page<Product> productPage = productRepository.findAll(pageable);
        if (productPage.getContent().isEmpty() || productPage.getContent() == null) {
            throw new NoProductFoundExceptions("No Products are present in the current list ");
        }
        return productPage;
    }

    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()) {
            throw new NoProductFoundExceptions("Product with id: " + id + " was not found!");
        }
        return product.get();
    }

    public Product create(Product product){

        return productRepository.save(product);
    }

}
