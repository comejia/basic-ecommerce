package com.comejia.pedidos.repositories;

import com.comejia.pedidos.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductRepository implements Repository<Product> {

    private final List<Product> products = new ArrayList<>();

    @Override
    public void save(Product entity) {
        this.products.add(entity);
    }

    @Override
    public Product findById(UUID id) {
        return this.products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product findByName(String name) {
        return this.products.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<Product> findAll() {
        return this.products;
    }
}
