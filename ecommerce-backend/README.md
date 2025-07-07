# Backend Ecommerce

Backend del proyecto Ecommerce

## Características 📋
### Gestión de Productos
* Agregar productos
* Listar todos los productos.
* Buscar productos por nombre o por ID.
* Actualizar datos de los productos.
* Eliminar productos por ID.

### Gestión de Pedidos
* Crear pedidos con los productos disponibles.
* Listar todos los pedidos.
* Eliminar un pedido y sus items asociados

## Tecnologias 🛠️
* Java 21
* Spring Boot
* Docker
* Maven
* MySQL

## Instalación 🔌
```bash
$ docker build -t ecommerce .
$ docker run -p 8080:8080 --rm -name ecommerce_back -e MARIADB_HOSTNAME=<local_IP or container_hostname> ecommerce:latest
```

## Uso 💻
El backend expone los siguientes recursos:
```js
GET /api/products
GET /api/products/{id}
GET /api/products?name=
POST /api/products
PUT /api/products/{id}
DELETE /api/products/{id}

GET /api/orders
GET /api/orders/{id}
POST /api/orders
DELETE /api/orders/{id}
```
