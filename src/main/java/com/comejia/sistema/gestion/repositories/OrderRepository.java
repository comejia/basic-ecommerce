package com.comejia.sistema.gestion.repositories;

import com.comejia.sistema.gestion.entities.Order;
import com.comejia.sistema.gestion.exceptions.OrderNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderRepository implements Repository<Order> {

    private final List<Order> orders = new ArrayList<>();

    @Override
    public void save(Order entity) {
        this.orders.add(entity);
    }

    @Override
    public Order findById(UUID id) {
        return this.orders.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElseThrow(OrderNotFoundException::new);
    }

    @Override
    public Order findByName(String name) {
        return null;
    }

    @Override
    public void delete(Order entity) {
        this.orders.remove(entity);
    }

    @Override
    public void deleteById(UUID id) {
        Order order = findById(id);
        delete(order);
    }

    @Override
    public List<Order> findAll() {
        return this.orders;
    }
}
