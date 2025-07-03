package com.comejia.ecommerce.services;

import com.comejia.ecommerce.dtos.OrderDto;
import com.comejia.ecommerce.entities.Order;
import com.comejia.ecommerce.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<OrderDto> findById(Long id) {
//        Optional<Order> order = this.repository.findById(id);
//        return order.map(OrderDto::from);
        return Optional.empty();
    }

    @Override
    public List<OrderDto> findAll() {
//        return this.repository.findAll().stream().map(OrderDto::from).toList();
        return null;
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
//        Order order = OrderDto.toEntity(orderDto);
//        Order savedOrder = this.repository.save(order);
//        return OrderDto.from(savedOrder);
////        if (!orderDto.isEmpty()) {
////            orderDto.confirm();
////            this.repository.save(orderDto);
////        }
        return null;
    }

//    @Override
//    public Order findByName(String name) {
//        return this.repository.findByName(name);
//    }
//
//    @Override
//    public void delete(Order entity) {
//        this.repository.delete(entity);
//    }
//
//    @Override
//    public void deleteById(UUID id) {
//        this.repository.deleteById(id);
//    }
//
//    @Override
//    public void update(Order entity, Order newEntity) {
//
//    }
}
