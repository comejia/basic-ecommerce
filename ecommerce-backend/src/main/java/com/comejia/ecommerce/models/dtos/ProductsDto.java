package com.comejia.ecommerce.models.dtos;

import com.comejia.ecommerce.models.entities.Product;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductsDto {

    @JsonProperty("products")
    private List<Product> products;

    @JsonCreator
    public ProductsDto(List<Product> products) {
        this.products = products;
    }
}
