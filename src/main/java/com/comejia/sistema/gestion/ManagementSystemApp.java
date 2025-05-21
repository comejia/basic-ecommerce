package com.comejia.sistema.gestion;

import com.comejia.sistema.gestion.entities.Item;
import com.comejia.sistema.gestion.entities.Product;
import com.comejia.sistema.gestion.entities.Order;
import com.comejia.sistema.gestion.exceptions.InsufficientStockException;
import com.comejia.sistema.gestion.exceptions.ProductNotFoundException;
import com.comejia.sistema.gestion.repositories.OrderRepository;
import com.comejia.sistema.gestion.repositories.ProductRepository;
import com.comejia.sistema.gestion.services.OrderService;
import com.comejia.sistema.gestion.services.ProductService;

import java.util.Scanner;
import java.util.UUID;

public class ManagementSystemApp {

    public static void main(String[] args) {

        ProductService productService = new ProductService(new ProductRepository());
        OrderService orderService = new OrderService(new OrderRepository());

        Scanner scanner = new Scanner(System.in);
        int option;

        initializeProducts(productService);

        do {
            menu();
            option = scanner.nextInt(); scanner.nextLine();

            switch (option) {
                case 1: {
                    System.out.println("\nIngrese los datos del producto:");

                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Precio: ");
                    double price = scanner.nextDouble(); scanner.nextLine();
                    System.out.print("Stock: ");
                    int stock = scanner.nextInt(); scanner.nextLine();

                    Product product = new Product(name, price, stock);
                    productService.save(product);
                    System.out.println("\nProducto agregado con éxito!");
                    break;
                }
                case 2: {
                    System.out.println("\nListado de productos:");
                    productService.findAll().forEach(System.out::println);
                    break;
                }
                case 3: {
                    Product product;
                    System.out.print("\nIngrese el nombre o ID del producto: ");
                    String nameOrID = scanner.nextLine();
                    try {
                        if (isValidUUID(nameOrID)) {
                            product = productService.findById(UUID.fromString(nameOrID));
                        } else {
                            product = productService.findByName(nameOrID);
                        }
                        System.out.println("\nProducto encontrado: " + product);

                        System.out.print("\n¿Desea modificar el producto? (S/N): ");
                        String confirmation = scanner.nextLine();
                        if (confirmation.equalsIgnoreCase("S")) {
                            System.out.print("Nuevo precio: ");
                            double newPrice = scanner.nextDouble(); scanner.nextLine();
                            System.out.print("Nuevo stock: ");
                            int newStock = scanner.nextInt(); scanner.nextLine();

                            productService.update(product, new Product("", newPrice, newStock));
                            System.out.println("\nProducto actualizado con éxito!");
                        }
                    } catch (ProductNotFoundException e) {
                        System.out.println("\nHubo un error al buscar el producto: " + e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("\nHubo un error al modificar el producto: " + e.getMessage());
                    }
                    break;
                }
                case 4: {
                    System.out.print("\nIngrese el ID del producto a eliminar: ");
                    String id = scanner.nextLine();
                    try {
                        Product product = productService.findById(UUID.fromString(id));
                        System.out.print("\n¿Esta seguro que quiere eliminar el producto? (S/N): ");
                        String confirmation = scanner.nextLine();
                        if (!confirmation.equalsIgnoreCase("S")) {
                            System.out.println("Eliminación cancelada.");
                            break;
                        }
                        productService.delete(product);
                        System.out.println("\nProducto eliminado con éxito!");
                    } catch (ProductNotFoundException e) {
                        System.out.println("\nHubo un error al eliminar el producto: " + e.getMessage());
                    }
                    break;
                }
                case 5: {
                    Order order = new Order();
                    while (true) {
                        System.out.print("\nIngrese el nombre del producto a agregar al pedido: ");
                        String name = scanner.nextLine();
                        System.out.print("Ingrese la cantidad: ");
                        int quantity = scanner.nextInt(); scanner.nextLine();

                        try {
                            Product product = productService.findByName(name);
                            order.addItem(new Item(product, quantity));
                        } catch (ProductNotFoundException | InsufficientStockException | IllegalArgumentException e) {
                            System.out.println("\nHubo un error al agregar el producto al pedido: " + e.getMessage());
                        }

                        System.out.print("\n¿Desea agregar otro producto al pedido? (S/N): ");
                        String confirmation = scanner.nextLine();
                        if (!confirmation.equalsIgnoreCase("S")) {
                            break;
                        }
                    }
                    orderService.save(order);
                    System.out.println("\nOrden creada con éxito!");
                    break;
                }
                case 6: {
                    System.out.println("Listado de pedidos:");
                    orderService.findAll().forEach(System.out::println);
                    break;
                }
                case 7: {
                    System.out.println("\nFin del programa.");
                    break;
                }
                default: {
                    System.out.println("\nOpción no válida. Por favor, intente nuevamente.");
                }
            }

            if (option != 7) {
                System.out.print("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        } while (option != 7);

        scanner.close();
    }

    private static void initializeProducts(ProductService service) {
        service.save(new Product("Cafe Premium", 8_200.00, 30));
        service.save(new Product("Laptop", 2_000_000.00, 5));
        service.save(new Product("Mouse", 5_000.00, 50));
    }

    private static void initializeOrders(OrderService service) {
        service.save(new Order());
    }

    private static void menu() {
        System.out.println("\n******** SISTEMA DE GESTIÓN ********");
        System.out.println("1) Agregar producto");
        System.out.println("2) Listar productos");
        System.out.println("3) Buscar producto por nombre o ID");
        System.out.println("4) Eliminar producto por ID");
        System.out.println("5) Crear pedido");
        System.out.println("6) Listar pedidos");
        System.out.println("7) Salir");

        System.out.print("\nElija una opción: ");
    }

    private static boolean isValidUUID(String id) {
        try {
            UUID.fromString(id);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}