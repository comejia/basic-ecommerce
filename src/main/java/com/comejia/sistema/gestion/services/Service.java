package com.comejia.sistema.gestion.services;

import java.util.List;
import java.util.UUID;

public interface Service<T> {

    void save(T entity);

    T findById(UUID id);

    T findByName(String name);

    void delete(T entity);

    void deleteById(UUID id);

    void update(T entity, T newEntity);

    List<T> findAll();
}
