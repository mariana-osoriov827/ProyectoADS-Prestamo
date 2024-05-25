package ads.puj.proyectoadsprestamo.negocio;

import ads.puj.proyectoadsprestamo.dominio.*;
import ads.puj.proyectoadsprestamo.dominio.Libro;
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
            return true;
        }
    }

    @Override
    public void iniciarPrestamo(String nombreEstudiante, String cedulaEstudiante) throws IllegalArgumentException{
        Estudiante estudiante = new Estudiante(cedulaEstudiante, nombreEstudiante);
        prestamoactual.setPrestatario(estudiante);
    }

    @Override
    public void agregarLibroAlPrestamo(Libro libro, int cantidad) {
        if(cantidad!=0) {
            for (Linea l : prestamoactual.getLineas()) {
                if (l.getLibro().equals(libro)) {
                    l.setCantidad(l.getCantidad() + cantidad);
                    return;
                }
            }
            Linea linea = new Linea(cantidad, libro);
            prestamoactual.agregarLinea(linea);
        }
    }
    @Override
    public void limpiarPrestamo(){
        prestamoactual=null;
        prestamoactual = new Prestamo();
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
        double total = 0;
        for(Linea linea: prestamoactual.getLineas()){
            total+=linea.getLibro().getPrecio();
        }
        return total;
    }

    @Override
    public void terminarPrestamo() {

    }

    @Override
    public void guardarPrestamo() {
       fs.guardarPrestamo(prestamoactual);
    }
}