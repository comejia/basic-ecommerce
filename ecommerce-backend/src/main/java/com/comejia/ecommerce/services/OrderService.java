package com.comejia.ecommerce.services;


import com.comejia.ecommerce.dtos.OrderDto;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Optional<OrderDto> findById(Long id);

    List<OrderDto> findAll();

//    Optional<Product> findByName(String name);

    OrderDto save(OrderDto orderDto);

//    void delete(Product product);

//    void deleteById(Long id);

//    void update(ProductDto entity, ProductDto newEntity);

}
