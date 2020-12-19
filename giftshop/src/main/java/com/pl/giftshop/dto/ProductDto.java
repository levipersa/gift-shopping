package com.pl.giftshop.dto;

import com.pl.giftshop.model.ProductCategory;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
public class ProductDto {

    public ProductDto(Long id, String name, String description, BigDecimal unitPrice, String imageUrl, int unitsInStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.imageUrl = imageUrl;
        this.unitsInStock = unitsInStock;
    }

    private Long id;

    private String name;

    private String description;

    private BigDecimal unitPrice;

    private String imageUrl;

    private int unitsInStock;

}
