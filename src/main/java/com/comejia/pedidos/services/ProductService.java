package com.comejia.pedidos.services;

import com.comejia.pedidos.entities.Product;
import com.comejia.pedidos.repositories.Repository;

import java.util.List;
import java.util.UUID;

public class ProductService implements Service<Product> {

    private final Repository<Product> repository;

    public ProductService(Repository<Product> repository) {
        this.repository = repository;
    }

    @Override
    public void save(Product product) {
        this.repository.save(product);
    }

    @Override
    public Product findById(UUID id) {
        return this.repository.findById(id);
    }

    @Override
    public Product findByName(String name) {
        return this.repository.findByName(name);
    }

    @Override
    public void delete(Product product) {
        this.repository.delete(product);
    }

    @Override
    public void deleteById(UUID id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return this.repository.findAll();
    }

}
