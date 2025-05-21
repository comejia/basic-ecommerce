package com.comejia.sistema.gestion.services;

import com.comejia.sistema.gestion.entities.Order;
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
        return this.repository.findById(id);
    }

    @Override
    public Order findByName(String name) {
        return this.repository.findByName(name);
    }

    @Override
    public void delete(Order entity) {
        this.repository.delete(entity);
    }

    @Override
    public void deleteById(UUID id) {
        this.repository.deleteById(id);
    }

    @Override
    public void update(Order entity, Order newEntity) {

    }

    @Override
    public List<Order> findAll() {
        return this.repository.findAll();
    }
}
