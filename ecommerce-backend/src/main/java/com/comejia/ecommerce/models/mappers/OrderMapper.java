package com.comejia.ecommerce.models.mappers;

import com.comejia.ecommerce.models.dtos.responses.OrderResponseDto;
import com.comejia.ecommerce.models.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    @Autowired
    private ItemMapper itemMapper;

    public OrderResponseDto toDto(Order order) {
        return new OrderResponseDto(
                order.getId(),
                null,
                order.getItems().stream().map(itemMapper::toDto).toList(),
                order.getTotal()
        );
    }
}
