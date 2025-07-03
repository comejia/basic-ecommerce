package com.comejia.ecommerce.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        this("El producto no existe en el sistema");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
