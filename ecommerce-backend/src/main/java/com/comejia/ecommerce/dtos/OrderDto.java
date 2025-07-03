package com.comejia.ecommerce.dtos;

import com.comejia.ecommerce.entities.Item;
import com.comejia.ecommerce.entities.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {

    private Long id;
    private List<Item> items;

    public static OrderDto from(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        return dto;
    }

    public static Order toEntity(OrderDto productDto) {
        Order order = new Order();
        order.setId(productDto.getId());
        return order;
    }
}
