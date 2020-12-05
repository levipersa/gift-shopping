package com.pl.giftshop.exceptions;

public class NoProductCategoryFoundException extends RuntimeException{

    public NoProductCategoryFoundException(String message) {
        super(message);
    }
}
