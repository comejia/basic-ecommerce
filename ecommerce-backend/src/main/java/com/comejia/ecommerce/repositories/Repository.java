package com.comejia.ecommerce.repositories;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    Optional<T> findById(Long id);

    List<T> findAll();

    Optional<T> findByName(String name);

    T save(T entity);

    void delete(T entity);

    void deleteById(Long id);

//    void update(T entity);
}
