package com.comejia.ecommerce.services;

import com.comejia.ecommerce.models.dtos.ProductDto;
import com.comejia.ecommerce.models.entities.Product;
import com.comejia.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ProductDto> findById(Long id) {
        Optional<Product> product = this.repository.findById(id);
        return product.map(ProductDto::from);
    }

    @Override
    public List<ProductDto> findAll() {
        return this.repository.findAll().stream().map(ProductDto::from).toList();
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = ProductDto.toEntity(productDto);
        Product savedProduct = this.repository.save(product);
        return ProductDto.from(savedProduct);
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
