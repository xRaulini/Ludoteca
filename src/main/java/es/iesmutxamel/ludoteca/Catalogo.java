package es.iesmutxamel.ludoteca;

import java.util.ArrayList;

public class Catalogo {
    // Creamos la lista vacia de videojuegos
    private ArrayList<Videojuego> videojuegos;

    // Cuando creemos el catalogo, crearemos tambien una lista vacia de videojuegos
    public Catalogo() {
        videojuegos = new ArrayList<>();
    }

    // Metodo para agregar videojuegos, pero verificando que ningun videojuego tiene el mismo ID
    public boolean agregarVideojuego(Videojuego videojuego) {
        if (buscarPorId(videojuego.getId()) != null) {
            return false;
        }

        videojuegos.add(videojuego);
        return true;
    }

    // Metodo para buscar videojuegos por ID
    public Videojuego buscarPorId(int id) {
        for (Videojuego videojuego : videojuegos) {
            if (videojuego.getId() == id) {
                return videojuego;
            }
        }
        return null;
    }

    // Metodo para eliminar videojuego por ID
    public boolean eliminarPorId(int id) {
        Videojuego videojuego = buscarPorId(id);

        if (videojuego != null) {
            videojuegos.remove(videojuego);
            return true;
        }
        return false;
    }

    public int obtenerCantidad() {
        return videojuegos.size();
    }

    public ArrayList<Videojuego> obtenerVideojuegos() {
        return videojuegos;
    }
}
