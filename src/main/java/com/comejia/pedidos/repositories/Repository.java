package com.comejia.pedidos.repositories;

import java.util.List;
import java.util.UUID;

public interface Repository<T> {

    void save(T entity);

    T findById(UUID id);

    T findByName(String name);

    void delete(T entity);

    void deleteById(UUID id);

//    void update(T entity);

    List<T> findAll();
}
