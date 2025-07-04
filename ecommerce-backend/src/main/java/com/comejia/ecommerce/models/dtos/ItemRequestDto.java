package com.comejia.ecommerce.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemRequestDto {

    private Long productId;
    private int quantity;
}
