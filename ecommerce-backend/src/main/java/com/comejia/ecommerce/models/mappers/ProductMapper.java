package com.comejia.ecommerce.models.mappers;

import com.comejia.ecommerce.models.dtos.ProductRequestDto;
import com.comejia.ecommerce.models.dtos.ProductResponseDto;
import com.comejia.ecommerce.models.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponseDto toDto(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                "",
                product.getPrice(),
                "",
                "",
                product.getStock()
        );
    }

    public Product toEntity(ProductRequestDto productRequestDto) {
        return new Product(
                productRequestDto.getName(),
                productRequestDto.getPrice(),
                productRequestDto.getStock()
        );
    }
}
