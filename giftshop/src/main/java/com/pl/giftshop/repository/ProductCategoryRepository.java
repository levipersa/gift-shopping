package com.pl.giftshop.repository;

import com.pl.giftshop.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}