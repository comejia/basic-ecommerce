package com.comejia.ecommerce.models.mappers;

import com.comejia.ecommerce.models.dtos.ProductRequestDto;
import com.comejia.ecommerce.models.dtos.ProductResponseDto;
import com.comejia.ecommerce.models.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponseDto toDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription("");
        dto.setPrice(product.getPrice());
        dto.setCategoria("");
        dto.setUrl("");
        dto.setStock(product.getStock());
        return dto;
    }

    public Product toEntity(ProductRequestDto productRequestDto) {
        return new Product(
                productRequestDto.getName(),
                productRequestDto.getPrice(),
                productRequestDto.getStock()
        );
    }
}
