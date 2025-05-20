package com.comejia.sistema.gestion.exceptions;

public class InsufficientStock extends RuntimeException {

    public InsufficientStock(String message) {
        super(message);
    }
}
