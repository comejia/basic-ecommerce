package com.comejia.pedidos;

import com.comejia.pedidos.entities.Product;
import com.comejia.pedidos.repositories.ProductRepository;
import com.comejia.pedidos.services.ProductService;

public class Main {

    public static void main(String[] args) {

        ProductService service = new ProductService(new ProductRepository());

        service.save(new Product("Cafe Premium", 8_200.00, 12));
        service.save(new Product("Laptop", 2_000_000.00, 3));
        service.save(new Product("Mouse", 5_000.00, 20));

        service.findAll().forEach(System.out::println);
    }
}