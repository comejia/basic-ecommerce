package com.comejia.pedidos.services;

import java.util.List;
import java.util.UUID;

public interface Service<T> {

    void save(T entity);

    T findById(UUID id);

    T findByName(String name);

//    void deleteById(UUID id);
//
//    void update(T entity);

    List<T> findAll();
}
