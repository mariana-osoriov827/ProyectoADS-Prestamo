package ads.puj.proyectoadsprestamo.dominio;

public class Libro {
    Integer isbn;
    String nombre;
    Float precio;

    public Libro(Integer isbn, String nombre, Float precio) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Libro() {
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn=" + isbn +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
