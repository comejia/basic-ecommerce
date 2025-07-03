package com.comejia.ecommerce.repositories;

import com.comejia.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

//    private final List<Product> products = new ArrayList<>();
//
//    @Override
//    public void save(Product entity) {
//        this.products.add(entity);
//    }
//
//    @Override
//    public Product findById(UUID id) {
//        return this.products.stream()
//                .filter(p -> p.getId().equals(id))
//                .findFirst()
//                .orElseThrow(ProductNotFoundException::new);
//    }
//
//    @Override
//    public Product findByName(String name) {
//        return this.products.stream()
//                .filter(p -> p.getName().equals(name))
//                .findFirst()
//                .orElseThrow(ProductNotFoundException::new);
//    }
//
//    @Override
//    public void delete(Product entity) {
//        this.products.remove(entity);
//    }
//
//    @Override
//    public void deleteById(UUID id) {
//        Product product = findById(id);
//        delete(product);
//    }
//
//    @Override
//    public List<Product> findAll() {
//        return this.products;
//    }
}
