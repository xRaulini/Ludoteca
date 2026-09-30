package es.iesmutxamel.ludoteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CatalogoTest {

    private Catalogo catalogo;

    @Before
    public void preparar() {
        catalogo = new Catalogo();
    }

    @Test
    public void catalogoNuevoEstaVacio() {
        assertEquals(0, catalogo.obtenerCantidad());
    }

    @Test
    public void sePuedeAgregarVideojuego() {

        Videojuego videojuego =
                new Videojuego(1, "Minecraft", "PC", 20, 5);

        catalogo.agregarVideojuego(videojuego);

        assertEquals(1, catalogo.obtenerCantidad());
    }

    @Test
    public void noSePuedenRepetirIds() {

        Videojuego videojuego1 =
                new Videojuego(1, "Minecraft", "PC", 20, 5);

        Videojuego videojuego2 =
                new Videojuego(1, "FIFA", "PS5", 30, 3);

        catalogo.agregarVideojuego(videojuego1);

        boolean resultado = catalogo.agregarVideojuego(videojuego2);

        assertFalse(resultado);
        assertEquals(1, catalogo.obtenerCantidad());
    }
}