package com.comejia.ecommerce.services;

import com.comejia.ecommerce.dtos.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<ProductDto> findById(Long id);

    List<ProductDto> findAll();

//    Optional<Product> findByName(String name);

    ProductDto save(ProductDto productDto);

//    void delete(Product product);

//    void deleteById(Long id);

//    void update(ProductDto entity, ProductDto newEntity);
}
