package ads.puj.proyectoadsprestamo.dominio;

public class Linea {
    Integer cantidad;
    Libro libro;

    public Linea(Integer cantidad, Libro libro) {
        this.cantidad = cantidad;
        this.libro = libro;
    }

    public Linea() {
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "libro=" + libro.getNombre() +
                "cantidad=" + cantidad;
    }
}
