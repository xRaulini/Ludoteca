package es.iesmutxamel.ludoteca;

public class Videojuego {


    private String titulo;
    private String plataforma;
    private double precio;
    private int stock;

    // Constructor
    public Videojuego(int id, String titulo, String plataforma, double precio, int stock) {
        this.Id = Id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.precio = precio;
        this.stock = stock;
    }

    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ID: " + Id + " | " + "Titulo: " + titulo + " | " + "Plataforma: " + plataforma + " | " + "Precio: " +
                precio + "€ | " + "Stock: " + stock;
    }
}