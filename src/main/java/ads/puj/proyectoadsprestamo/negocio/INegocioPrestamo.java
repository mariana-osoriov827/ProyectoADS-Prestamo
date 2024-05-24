package ads.puj.proyectoadsprestamo.negocio;

import ads.puj.proyectoadsprestamo.dominio.Libro;
import ads.puj.proyectoadsprestamo.dominio.Libro;
import ads.puj.proyectoadsprestamo.dominio.Prestamo;

import java.util.List;

public interface INegocioPrestamo {
    public List<Libro> getCatalogo();

    public void setCatalogo(List<Libro> catalogo);

    public Prestamo getPrestamoactual();

    public void setPrestamoactual(Prestamo prestamoactual);

    boolean cargarLibros();
    public List<String> getNombresCatalogo();
    void iniciarPrestamo(String nombreEstudiante, String cedulaEstudiante);
    void agregarLibroAlPrestamo(Libro libro, int cantidad);
    void listarLibrosDelPrestamo();
    void eliminarLibroDelPrestamo(Libro libro);
    void modificarCantidadLibroDelPrestamo(Libro libro, int nuevaCantidad);
    double totalizarPrestamo();
    void terminarPrestamo();
    void guardarPrestamo();

}
