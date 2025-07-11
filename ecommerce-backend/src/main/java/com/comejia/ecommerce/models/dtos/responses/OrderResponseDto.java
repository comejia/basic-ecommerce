package com.comejia.ecommerce.models.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class OrderResponseDto {

    private Long orderId;
    private Long userId;
    private List<ItemResponseDto> items;
    private double total;
}
