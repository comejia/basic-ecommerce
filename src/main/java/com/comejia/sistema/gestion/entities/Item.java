package com.comejia.sistema.gestion.entities;

import java.util.UUID;

public class Item {

    private final UUID id;
    private Product product;
    private int quantity;

    public Item(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        this.id = UUID.randomUUID();
        this.product = product;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return this.product.getPrice() * this.quantity;
    }

    public int getProductStock() {
        return this.product.getStock();
    }

    public boolean sameProduct(Product product) {
        return this.product.equals(product);
    }

    @Override
    public String toString() {
        return "{" +
                "product: " + product.getName() +
                ", quantity: " + quantity +
                '}';
    }
}
