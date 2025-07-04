package com.comejia.ecommerce.models.dtos;

import com.comejia.ecommerce.models.entities.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {

    private Long id;
    private List<ItemDto> items;

    public static OrderDto from(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
//        dto.setItems(order.getItems().stream().map(i -> new ItemDto(i.)));
        return dto;
    }

    public static Order toEntity(OrderDto productDto) {
        Order order = new Order();
        order.setId(productDto.getId());
        return order;
    }
}
