package com.pl.giftshop.dto;

import com.pl.giftshop.model.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
public class ProductCategoryDto {


    private Long id;

    private String categoryName;

    private Set<ProductDto> products;


}
