package com.comejia.sistema.gestion.entities.models;

import com.comejia.sistema.gestion.entities.Product;

import java.util.UUID;

public class Item {

    private final UUID id;
    private Product product;
    private int quantity;

    public Item(Product product, int quantity) {
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

    @Override
    public String toString() {
        return "Item{" +
                "product: " + product.getName() +
                ", quantity: " + quantity +
                '}';
    }
}
