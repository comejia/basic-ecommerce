package com.comejia.ecommerce.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id", nullable = false)
    private List<Item> items = new ArrayList<>();

    public Order() {
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public double getTotal() {
        return this.items.stream().mapToDouble(Item::getTotal).sum();
    }

    @Override
    public String toString() {
        return "{" +
                "id: " + id +
                ", items: " + items +
                ", total price: " + getTotal() +
                '}';
    }

}
