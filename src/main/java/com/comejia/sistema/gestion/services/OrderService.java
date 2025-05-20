package com.comejia.sistema.gestion.services;

import com.comejia.sistema.gestion.entities.Product;
import com.comejia.sistema.gestion.entities.models.Order;
import com.comejia.sistema.gestion.repositories.Repository;

import java.util.List;
import java.util.UUID;

public class OrderService implements Service<Order> {

    private final Repository<Order> repository;

    public OrderService(Repository<Order> repository) {
        this.repository = repository;
    }

    @Override
    public void save(Order entity) {
        if (!entity.isEmpty()) {
            entity.confirm();
            this.repository.save(entity);
        }
    }

    @Override
    public Order findById(UUID id) {
        return null;
    }

    @Override
    public Order findByName(String name) {
        return null;
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public List<Order> findAll() {
        return this.repository.findAll();
    }
}
