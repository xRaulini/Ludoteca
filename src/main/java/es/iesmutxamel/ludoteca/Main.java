package es.iesmutxamel.ludoteca;

import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Crear el videojuego del ejemplo
        Videojuego juego1 = new Videojuego(101, "Órbita", "PC", 19.95, 7);
        // Crear el videojuego nuevo
        Videojuego juego2 = new Videojuego(102,"Valorant", "PC", 20.00,0);
        System.out.println(juego1);
        System.out.println(juego2);
    }
}
