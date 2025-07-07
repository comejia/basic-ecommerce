package com.comejia.ecommerce.services;

import com.comejia.ecommerce.models.dtos.OrderRequestDto;
import com.comejia.ecommerce.models.dtos.OrderResponseDto;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Optional<OrderResponseDto> findById(Long id);

    List<OrderResponseDto> findAll();

    OrderResponseDto save(OrderRequestDto orderRequestDto);

    OrderResponseDto update(Long id, OrderRequestDto orderRequestDto);

    void deleteById(Long id);
}
