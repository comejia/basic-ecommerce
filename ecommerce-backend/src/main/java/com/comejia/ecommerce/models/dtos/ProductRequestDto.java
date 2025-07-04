package com.comejia.ecommerce.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {

    private String name;
    private String description;
    private double price;
    private String categoria;
    private String url;
    private int stock;
}
