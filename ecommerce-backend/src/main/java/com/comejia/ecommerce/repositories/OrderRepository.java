package com.comejia.ecommerce.repositories;

import com.comejia.ecommerce.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
