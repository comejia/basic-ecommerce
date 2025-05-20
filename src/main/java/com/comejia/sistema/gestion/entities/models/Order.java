package com.comejia.sistema.gestion.entities.models;

import com.comejia.sistema.gestion.entities.Product;
import com.comejia.sistema.gestion.exceptions.InsufficientStock;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private final UUID id;
    private final List<Item> items;

    public Order() {
        this.id = UUID.randomUUID();
        this.items = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void addItem(Product product, int quantity) {
        if (product.getStock() < quantity) {
            throw new InsufficientStock("No hay suficiente stock");
        }
        this.items.add(new Item(product, quantity));
    }

    public void confirm() {
        this.items.forEach(i -> {
            Product product = i.getProduct();
            product.reduceStock(i.getQuantity());
        });
    }

    public double total() {
        return this.items.stream()
                .mapToDouble(Item::getTotal)
                .sum();
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    @Override
    public String toString() {
        return "Order{" +
                "uuid: " + id +
                ", items: " + items +
                ", total price: " + total() +
                '}';
    }

}
