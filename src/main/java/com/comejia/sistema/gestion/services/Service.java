package com.comejia.sistema.gestion.services;

import com.comejia.sistema.gestion.entities.Product;

import java.util.List;
import java.util.UUID;

public interface Service<T> {

    void save(T entity);

    T findById(UUID id);

    T findByName(String name);

    void delete(Product product);

    void deleteById(UUID id);

//    void update(T entity);

    List<T> findAll();
}
