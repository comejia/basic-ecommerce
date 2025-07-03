package com.comejia.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Product product;
    private int quantity;

    public Item() {
    }

    public Item(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        this.product = product;
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
