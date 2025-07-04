package com.comejia.ecommerce.models.mappers;

import com.comejia.ecommerce.models.dtos.OrderResponseDto;
import com.comejia.ecommerce.models.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    @Autowired
    private ItemMapper itemMapper;

    public OrderResponseDto toDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setOrderId(order.getId());
        dto.setUserId(null);
        dto.setItems(order.getItems().stream().map(itemMapper::toDto).toList());
        dto.setTotal(order.getTotal());
        return dto;
    }

}
