package com.pl.giftshop.exceptions;

import java.util.NoSuchElementException;

public class NoUsersFoundExceptions extends RuntimeException {

    public NoUsersFoundExceptions(String s) {
        super(s);
    }
}
