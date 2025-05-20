package com.comejia.sistema.gestion;

import com.comejia.sistema.gestion.entities.Product;
import com.comejia.sistema.gestion.exceptions.ProductNotFoundException;
import com.comejia.sistema.gestion.repositories.ProductRepository;
import com.comejia.sistema.gestion.services.ProductService;

import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        ProductService service = new ProductService(new ProductRepository());
        Scanner scanner = new Scanner(System.in);
        int option;

        initializeProducts(service);

        do {
            menu();
            option = scanner.nextInt(); scanner.nextLine();

            switch (option) {
                case 1: {
                    System.out.println("Ingrese los datos del producto:");

                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();

                    System.out.print("Precio: ");
                    double price = scanner.nextDouble(); scanner.nextLine();

                    System.out.print("Stock: ");
                    int stock = scanner.nextInt(); scanner.nextLine();

                    Product product = new Product(name, price, stock);
                    service.save(product);
                    System.out.println("Producto agregado con éxito.");
                    break;
                }
                case 2: {
                    System.out.println("Lista de productos:");
                    service.findAll().forEach(System.out::println);
                    break;
                }
                case 3: {
                    System.out.print("Ingrese el nombre del producto a buscar: ");
                    String name = scanner.nextLine();
                    try {
                        Product product = service.findByName(name);
                        System.out.println("Producto encontrado: " + product);
                    } catch (ProductNotFoundException e) {
                        System.out.println("Hubo un error al buscar el producto: " + e.getMessage());
                    }
                    break;
                }
                case 4: {
                    System.out.print("Ingrese el ID del producto a buscar: ");
                    String id = scanner.nextLine();
                    try {
                        Product product = service.findById(UUID.fromString(id));
                        System.out.println("Producto encontrado: " + product);
                    } catch (ProductNotFoundException e) {
                        System.out.println("Hubo un error al buscar el producto: " + e.getMessage());
                    }
                    break;
                }
                case 5: {
                    System.out.print("Ingrese el nombre del producto a actualizar: ");
                    String name = scanner.nextLine();
                    try {
                        Product product = service.findByName(name);

                        System.out.print("Nuevo precio: ");
                        double newPrice = scanner.nextDouble(); scanner.nextLine();
                        product.setPrice(newPrice);

                        System.out.print("Nuevo stock: ");
                        int newStock = scanner.nextInt(); scanner.nextLine();
                        product.setStock(newStock);

                        System.out.println("Producto actualizado con éxito.");
                    } catch (ProductNotFoundException e) {
                        System.out.println("Hubo un error al buscar el producto: " + e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Hubo un error al actualizar el producto: " + e.getMessage());
                    }
                    break;
                }
                case 6: {
                    System.out.print("Ingrese el ID del producto a eliminar: ");
                    String id = scanner.nextLine();
                    try {
                        Product product = service.findById(UUID.fromString(id));
                        System.out.println("Esta seguro que quiere eliminar el producto?? (S/N)");
                        String confirmation = scanner.nextLine();
                        if (!confirmation.equalsIgnoreCase("S")) {
                            System.out.println("Eliminación cancelada.");
                            break;
                        }
                        service.delete(product);
                        System.out.println("Producto eliminado con éxito.");
                    } catch (ProductNotFoundException e) {
                        System.out.println("Hubo un error al eliminar el producto: " + e.getMessage());
                    }
                    break;
                }
            }

            System.out.println("\nPresione Enter para continuar...");
            scanner.nextLine();
        } while (option != 8);

        System.out.println("Fin del programa.");
        scanner.close();
    }

    private static void initializeProducts(ProductService service) {
        service.save(new Product("Cafe Premium", 8_200.00, 12));
        service.save(new Product("Laptop", 2_000_000.00, 3));
        service.save(new Product("Mouse", 5_000.00, 20));
    }

    private static void menu() {
        System.out.println("\n******** SISTEMA DE GESTIÓN ********");
        System.out.println("1) Agregar producto");
        System.out.println("2) Listar productos");
        System.out.println("3) Buscar producto por nombre");
        System.out.println("4) Buscar producto por ID");
        System.out.println("5) Actualizar producto por Nombre");
        System.out.println("6) Eliminar producto por ID");
        System.out.println("7) Crear pedido");
        System.out.println("8) Listar pedidos");
        System.out.println("9) Salir");

        System.out.print("\nIngrese una opción: ");
    }
}