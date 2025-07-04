package com.comejia.ecommerce.services;

import com.comejia.ecommerce.exceptions.InsufficientStockException;
import com.comejia.ecommerce.models.dtos.OrderRequestDto;
import com.comejia.ecommerce.models.dtos.OrderResponseDto;
import com.comejia.ecommerce.models.entities.Item;
import com.comejia.ecommerce.models.entities.Order;
import com.comejia.ecommerce.exceptions.ProductNotFoundException;
import com.comejia.ecommerce.models.mappers.OrderMapper;
import com.comejia.ecommerce.repositories.OrderRepository;
import com.comejia.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ProductRepository productRepository,
                            OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public Optional<OrderResponseDto> findById(Long id) {
        return this.orderRepository.findById(id).map(orderMapper::toDto);
    }

    @Override
    public List<OrderResponseDto> findAll() {
        return this.orderRepository.findAll().stream().map(orderMapper::toDto).toList();
    }

    @Override
    public OrderResponseDto save(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        orderRequestDto.getItems()
                .forEach(itemDto -> this.productRepository
                        .findById(itemDto.getProductId())
                        .ifPresentOrElse(
                                product -> {
                                    if (!product.hasStock(itemDto.getQuantity())) {
                                        throw new InsufficientStockException();
                                    }
                                    order.addItem(new Item(product, itemDto.getQuantity()));
                                    product.reduceStock(itemDto.getQuantity());
                                },
                                () -> {
                                    throw new ProductNotFoundException();
                                }
                        )
                );

        Order savedOrder = this.orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
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
