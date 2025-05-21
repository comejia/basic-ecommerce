package com.comejia.sistema.gestion.exceptions;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException() {
        this("La orden no existe en el sistema");
    }

    public OrderNotFoundException(String message) {
        super(message);
    }
}
