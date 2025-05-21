package com.comejia.sistema.gestion.services;

import com.comejia.sistema.gestion.entities.Product;
import com.comejia.sistema.gestion.repositories.Repository;

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
    public void delete(Product entity) {
        this.repository.delete(entity);
    }

    @Override
    public void deleteById(UUID id) {
        this.repository.deleteById(id);
    }

    @Override
    public void update(Product entity, Product newEntity) {
//        entity.setName(newEntity.getName());
        entity.setPrice(newEntity.getPrice());
        entity.setStock(newEntity.getStock());
    }

    @Override
    public List<Product> findAll() {
        return this.repository.findAll();
    }

}
