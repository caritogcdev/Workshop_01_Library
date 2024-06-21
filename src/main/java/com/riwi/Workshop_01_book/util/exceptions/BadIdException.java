package com.riwi.Workshop_01_book.util.exceptions;

public class BadIdException extends RuntimeException {
    public BadIdException(String name) {
        super(name);
    }
}