package com.comejia.ecommerce.entities;

import com.comejia.ecommerce.exceptions.InsufficientStockException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<Item> items;

    public Order() {
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
