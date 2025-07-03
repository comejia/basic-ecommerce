package com.comejia.ecommerce.services;

import java.util.List;
import java.util.Optional;

public interface Service<T> {

    Optional<T> findById(Long id);

    List<T> findAll();

    Optional<T> findByName(String name);

    T save(T entity);

    void delete(T entity);

    void deleteById(Long id);

    void update(T entity, T newEntity);
}
