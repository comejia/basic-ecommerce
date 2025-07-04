package com.comejia.ecommerce.services;

import com.comejia.ecommerce.models.dtos.OrderDto;
import com.comejia.ecommerce.models.entities.Item;
import com.comejia.ecommerce.models.entities.Order;
import com.comejia.ecommerce.models.entities.Product;
import com.comejia.ecommerce.exceptions.ProductNotFoundException;
import com.comejia.ecommerce.repositories.OrderRepository;
import com.comejia.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Optional<OrderDto> findById(Long id) {
        Optional<Order> order = this.orderRepository.findById(id);
        return order.map(OrderDto::from);
    }

    @Override
    public List<OrderDto> findAll() {
        return this.orderRepository.findAll().stream().map(OrderDto::from).toList();
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        Order order = new Order();
        orderDto.getItems().forEach(itemDto -> {
            Optional<Product> product = this.productRepository.findById(itemDto.getProductId());
            product.ifPresentOrElse(
                    p -> {
                        order.addItem(new Item(p, itemDto.getQuantity()));
                        p.reduceStock(itemDto.getQuantity());
                    },
                    () -> {
                        throw new ProductNotFoundException();
                    }
            );
        });

        Order savedOrder = this.orderRepository.save(order);
        return OrderDto.from(savedOrder);
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
