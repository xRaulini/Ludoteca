package es.iesmutxamel.ludoteca;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Catalogo catalogo = new Catalogo();

        // Videojuegos iniciales
        Videojuego juego1 = new Videojuego(101, "Órbita", "PC", 19.95, 7);
        Videojuego juego2 = new Videojuego(102, "Valorant", "PC", 20.00, 20);

        catalogo.agregarVideojuego(juego1);
        catalogo.agregarVideojuego(juego2);

        int opcion;

        do {
            System.out.println();
            System.out.println("*** Ludoteca IES Mutxamel ***");
            System.out.println("1. Mostrar todos los videojuegos");
            System.out.println("2. Añadir un videojuego");
            System.out.println("3. Mostrar un resumen del catálogo");
            System.out.println("4. Consultar videojuegos con pocas unidades");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            // Comprobar que se introduce un número
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debes introducir un número.");
                scanner.next();
                System.out.print(">> Selecciona una opción: ");
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            // Opcion 1: Mostrar todos los videojuegos
            if (opcion == 1) {

                if (catalogo.obtenerCantidad() == 0) {
                    System.out.println("El catálogo está vacío.");
                } else {

                    for (Videojuego videojuego : catalogo.obtenerVideojuegos()) {
                        System.out.println(videojuego);
                    }
                }
            }

            // Opcion 2: Añadir un videojuego
            else if (opcion == 2) {
                int id;

                System.out.print("Introduce el ID: ");

                // Comprobar que lo que introducimos para el ID sea un numero
                while (!scanner.hasNextInt()) {
                    System.out.println("Error: el ID debe ser un número.");
                    scanner.next();
                    System.out.print("Introduce el ID: ");
                }

                id = scanner.nextInt();
                scanner.nextLine();

                // Comprobacion de que el ID no puede ser negativo, y sino comprobar si
                // el ID del videojuego existe
                if (id < 0) {
                    System.out.println("Error: el ID no puede ser negativo.");

                } else if (catalogo.buscarPorId(id) != null) {
                    System.out.println("Error: ya existe un videojuego con ese ID.");

                } else {
                    System.out.print("Introduce el título: ");
                    String titulo = scanner.nextLine();

                    if (titulo.isEmpty()) {
                        System.out.println("Error: el título no puede estar vacío.");
                    } else {
                        System.out.print("Introduce la plataforma: ");
                        String plataforma = scanner.nextLine();

                        if (plataforma.isEmpty()) {
                            System.out.println("Error: la plataforma no puede estar vacía.");

                        } else {
                            System.out.print("Introduce el precio: ");

                            while (!scanner.hasNextDouble()) {
                                System.out.println("Error: el precio debe ser un número.");
                                scanner.next();
                                System.out.print("Introduce el precio: ");
                            }

                            double precio = scanner.nextDouble();
                            scanner.nextLine();

                            if (precio < 0) {
                                System.out.println("Error: el precio no puede ser negativo.");
                            } else {

                                System.out.print("Introduce el stock: ");

                                while (!scanner.hasNextInt()) {
                                    System.out.println("Error: el stock debe ser un número.");
                                    scanner.next();
                                    System.out.print("Introduce el stock: ");
                                }

                                int stock = scanner.nextInt();
                                scanner.nextLine();

                                if (stock < 0) {
                                    System.out.println("Error: el stock no puede ser negativo.");
                                } else {

                                    Videojuego videojuego =
                                            new Videojuego(id, titulo, plataforma, precio, stock);

                                    catalogo.agregarVideojuego(videojuego);

                                    System.out.println("Videojuego añadido correctamente.");
                                }
                            }
                        }
                    }
                }
            }

            // Opcion 3: Mostrar resumen del catalogo
            else if (opcion == 3) {

                int cantidadVideojuegos = catalogo.obtenerCantidad();
                int totalUnidades = 0;
                double valorTotal = 0;

                for (Videojuego videojuego : catalogo.obtenerVideojuegos()) {

                    totalUnidades += videojuego.getStock();

                    valorTotal += videojuego.getPrecio() * videojuego.getStock();
                }

                System.out.println("Número de videojuegos diferentes: " + cantidadVideojuegos);
                System.out.println("Número total de unidades: " + totalUnidades);
                System.out.println("Valor total del stock: " + valorTotal + "€");
            }

            // Opcion 4: Mostrar videojuegos con pocas unidades
            else if (opcion == 4) {

                System.out.print("Introduce el límite de stock: ");

                while (!scanner.hasNextInt()) {
                    System.out.println("Error: debes introducir un número.");
                    scanner.next();
                    System.out.print("Introduce el límite de stock: ");
                }

                int limite = scanner.nextInt();
                scanner.nextLine();

                if (limite < 0) {

                    System.out.println("Error: el límite no puede ser negativo.");

                } else {

                    boolean encontrado = false;

                    for (Videojuego videojuego : catalogo.obtenerVideojuegos()) {

                        if (videojuego.getStock() <= limite) {
                            System.out.println(videojuego);
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No hay videojuegos con ese stock.");
                    }
                }
            }

            else if (opcion == 5) {
                System.out.println("Abandonando la aplicacion...");
            }

            else {
                System.out.println("Error: esa opción no existe.");
            }

        } while (opcion != 5);
        scanner.close();
    }
}