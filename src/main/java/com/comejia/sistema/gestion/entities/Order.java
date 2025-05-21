package com.comejia.sistema.gestion.entities;

import com.comejia.sistema.gestion.exceptions.InsufficientStockException;

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

    public void addItem(Item item) {
        int totalQuantity = this.items.stream()
                .filter(i -> i.sameProduct(item.getProduct()))
                .mapToInt(Item::getQuantity)
                .sum();

        if (item.getProductStock() < totalQuantity + item.getQuantity()) {
            throw new InsufficientStockException();
        }
        this.items.add(item);
    }

    public void confirm() {
        this.items.forEach(i -> {
            Product product = i.getProduct();
            product.reduceStock(i.getQuantity());
        });
    }

    public double totalPrice() {
        return this.items.stream()
                .mapToDouble(Item::getTotal)
                .sum();
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    @Override
    public String toString() {
        return "{" +
                "id: " + id +
                ", items: " + items +
                ", total price: " + totalPrice() +
                '}';
    }

}
