package com.comejia.ecommerce.services;

import com.comejia.ecommerce.models.dtos.ProductRequestDto;
import com.comejia.ecommerce.models.dtos.ProductResponseDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<ProductResponseDto> findById(Long id);

    List<ProductResponseDto> findAll();

    Optional<ProductResponseDto> findByName(String name);

    ProductResponseDto save(ProductRequestDto productRequestDto);

    ProductResponseDto update(Long id, ProductRequestDto productRequestDto);

    void deleteById(Long id);
}
