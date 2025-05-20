package com.comejia.sistema.gestion.entities;

import java.util.UUID;

public class Product {

    private final UUID id;
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("El precio no puede negativo");
        }
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede negativo");
        }
        this.stock = stock;
    }

    public void reduceStock(int quantity) {
        this.stock -= quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id: " + id +
                ", name: " + name +
                ", price: " + price +
                ", stock:" + stock +
                '}';
    }
}
