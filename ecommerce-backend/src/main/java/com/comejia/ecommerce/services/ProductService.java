package com.comejia.ecommerce.services;

import com.comejia.ecommerce.models.dtos.ProductRequestDto;
import com.comejia.ecommerce.models.dtos.ProductResponseDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<ProductResponseDto> findById(Long id);

    List<ProductResponseDto> findAll();

//    Optional<Product> findByName(String name);

    ProductResponseDto save(ProductRequestDto productRequestDto);

//    void delete(Product product);

//    void deleteById(Long id);

//    void update(ProductDto entity, ProductDto newEntity);
}
