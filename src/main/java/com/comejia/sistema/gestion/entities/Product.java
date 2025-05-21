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
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        this.stock = stock;
    }

    public void reduceStock(int quantity) {
        this.stock -= quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public String toString() {
        return "{" +
                "id: " + id +
                ", name: " + name +
                ", price: " + price +
                ", stock:" + stock +
                '}';
    }
}
