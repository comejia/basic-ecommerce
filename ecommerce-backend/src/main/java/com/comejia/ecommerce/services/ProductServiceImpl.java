package com.comejia.ecommerce.services;

import com.comejia.ecommerce.models.dtos.ProductRequestDto;
import com.comejia.ecommerce.models.dtos.ProductResponseDto;
import com.comejia.ecommerce.models.entities.Product;
import com.comejia.ecommerce.models.mappers.ProductMapper;
import com.comejia.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository repository, ProductMapper productMapper) {
        this.repository = repository;
        this.productMapper = productMapper;
    }

    @Override
    public Optional<ProductResponseDto> findById(Long id) {
        return this.repository.findById(id).map(productMapper::toDto);
    }

    @Override
    public List<ProductResponseDto> findAll() {
        return this.repository.findAll().stream().map(productMapper::toDto).toList();
    }

    @Override
    public ProductResponseDto save(ProductRequestDto productRequestDto) {
        Product product = productMapper.toEntity(productRequestDto);
        Product savedProduct = this.repository.save(product);
        return productMapper.toDto(savedProduct);
    }

//    @Override
//    public Optional<Product> findByName(String name) {
//        return this.repository.findByName(name);
//    }
//
//    @Override
//    public void delete(Product entity) {
//        this.repository.delete(entity);
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        this.repository.deleteById(id);
//    }
//
//    @Override
//    public void update(Product entity, Product newEntity) {
////        entity.setName(newEntity.getName());
//        entity.setPrice(newEntity.getPrice());
//        entity.setStock(newEntity.getStock());
//    }

}
