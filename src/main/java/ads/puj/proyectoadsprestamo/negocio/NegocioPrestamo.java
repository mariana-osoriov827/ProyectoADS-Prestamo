package ads.puj.proyectoadsprestamo.negocio;

import ads.puj.proyectoadsprestamo.dominio.Libro;
import ads.puj.proyectoadsprestamo.dominio.Estudiante;
import ads.puj.proyectoadsprestamo.dominio.Libro;
import ads.puj.proyectoadsprestamo.dominio.Prestamo;
import ads.puj.proyectoadsprestamo.integracion.IntegradorFileSystem;

import java.util.ArrayList;
import java.util.List;

public class NegocioPrestamo implements INegocioPrestamo{
    List<Libro> catalogo = new ArrayList<>();
    Prestamo prestamoactual = new Prestamo();
    IntegradorFileSystem integrador;
    private IntegradorFileSystem fs = new IntegradorFileSystem();
    public NegocioPrestamo(List<Libro> catalogo, Prestamo prestamoactual, IntegradorFileSystem integrador) {
        this.catalogo = catalogo;
        this.prestamoactual = prestamoactual;
        this.integrador = integrador;
    }

    public List<Libro> getCatalogo() {
        return catalogo;
    }
    public List<String> getNombresCatalogo() {
        List<String> nombres = new ArrayList<>();
        for(Libro libro:catalogo){
            nombres.add(libro.getNombre());
        }
        return nombres;
    }

    public void setCatalogo(List<Libro> catalogo) {
        this.catalogo = catalogo;
    }

    public Prestamo getPrestamoactual() {
        return prestamoactual;
    }

    public void setPrestamoactual(Prestamo prestamoactual) {
        this.prestamoactual = prestamoactual;
    }

    public IntegradorFileSystem getIntegrador() {
        return integrador;
    }

    public void setIntegrador(IntegradorFileSystem integrador) {
        this.integrador = integrador;
    }


    public NegocioPrestamo() {
    }
    @Override
    public boolean cargarLibros() {
        this.catalogo = fs.readLibrosFromJson();
        if(catalogo==null){
            return false;
        }
        else{
            System.out.println(catalogo);
            return true;
        }
    }

    @Override
    public void iniciarPrestamo(String nombreEstudiante, String cedulaEstudiante) {
        Estudiante estudiante = new Estudiante(Integer.parseInt(cedulaEstudiante), nombreEstudiante);
        prestamoactual.setPrestatario(estudiante);
    }

    @Override
    public void agregarLibroAlPrestamo(Libro libro, int cantidad) {

    }

    @Override
    public void listarLibrosDelPrestamo() {

    }

    @Override
    public void eliminarLibroDelPrestamo(Libro libro) {

    }

    @Override
    public void modificarCantidadLibroDelPrestamo(Libro libro, int nuevaCantidad) {

    }

    @Override
    public double totalizarPrestamo() {

        return 0.0;
    }

    @Override
    public void terminarPrestamo() {

    }

    @Override
    public void guardarPrestamo() {

    }
}