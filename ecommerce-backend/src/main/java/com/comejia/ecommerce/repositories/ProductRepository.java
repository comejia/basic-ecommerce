package com.comejia.ecommerce.repositories;

import com.comejia.ecommerce.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
