package com.comejia.sistema.gestion.repositories;

import com.comejia.sistema.gestion.entities.Product;
import com.comejia.sistema.gestion.exceptions.ProductNotFoundException;

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
                .orElseThrow(() -> new ProductNotFoundException("El producto no existe en el sistema"));
    }

    @Override
    public Product findByName(String name) {
        return this.products.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("El producto no existe en el sistema"));
    }

    @Override
    public void delete(Product entity) {
        this.products.remove(entity);
    }

    @Override
    public void deleteById(UUID id) {
        Product product = findById(id);
        delete(product);
    }

    @Override
    public List<Product> findAll() {
        return this.products;
    }
}
