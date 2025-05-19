package com.comejia.pedidos.entities;

import java.util.UUID;

public class Product {

    private UUID id;
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
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
