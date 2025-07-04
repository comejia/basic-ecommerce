package com.comejia.ecommerce.models.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequestDto {

    private Long userId;
    private List<ItemRequestDto> items;
}
