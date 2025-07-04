package com.comejia.ecommerce.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
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

    public int getProductStock() {
        return this.product.getStock();
    }

    public double getTotal() {
        return this.product.getPrice() * this.quantity;
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
