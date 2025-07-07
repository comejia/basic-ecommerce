package com.comejia.ecommerce.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemResponseDto {

    private Long productId;
    private String name;
    private double price;
    private int quantity;
    private double subTotal;
}
