package com.comejia.ecommerce.repositories;

import com.comejia.ecommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository {//extends JpaRepository<Order, Long> {

//    private final List<Order> orders = new ArrayList<>();
//
//    @Override
//    public void save(Order entity) {
//        this.orders.add(entity);
//    }
//
//    @Override
//    public Order findById(UUID id) {
//        return this.orders.stream()
//                .filter(o -> o.getId().equals(id))
//                .findFirst()
//                .orElseThrow(OrderNotFoundException::new);
//    }
//
//    @Override
//    public Order findByName(String name) {
//        return null;
//    }
//
//    @Override
//    public void delete(Order entity) {
//        this.orders.remove(entity);
//    }
//
//    @Override
//    public void deleteById(UUID id) {
//        Order order = findById(id);
//        delete(order);
//    }
//
//    @Override
//    public List<Order> findAll() {
//        return this.orders;
//    }
}
