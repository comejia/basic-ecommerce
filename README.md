# Ecommerce

Este proyecto permite simular la gestión de productos y realizar pedidos.

## Características 📋
* Arquitectura MVC con Spring Boot 3
* Docker para contenerizar los servicios
* Persistencia de datos en una Base de datos relacional

## Tecnologias 🛠️
Backend:
* Java 21
* Spring Boot
* Docker
* Maven
* MySQL

## Instalación 🔌
1. Configurar las variables de entorno del archivo ```.env```
2. Levantar los servicios con docker compose (incluido la db)
```bash
$ docker-compose up --build
```
3. (Opcional) Importar [datos](./data/ecommerce.sql) a la DB
```bash
$ docker exec -i <db_container_name> mariadb -u root <database_name> < ./data/ecommerce.sql
# Ej: docker exec -i ecommerce-db mariadb -u root ecommerce < ./data/ecommerce.sql
```

## Uso 💻
Los recursos que expone el backend estan en [Backend README](./ecommerce-backend/README.md). 
Tambien se puede importar la [colección de Postman](./data/Ecommerce.postman_collection.json) para probar.


