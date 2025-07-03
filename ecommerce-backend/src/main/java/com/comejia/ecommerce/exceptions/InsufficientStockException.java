package com.comejia.ecommerce.exceptions;

public class InsufficientStockException extends RuntimeException {

    public InsufficientStockException() {
        this("No hay suficiente stock");
    }

    public InsufficientStockException(String message) {
        super(message);
    }
}
