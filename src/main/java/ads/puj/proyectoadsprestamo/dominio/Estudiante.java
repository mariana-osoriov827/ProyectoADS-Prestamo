package ads.puj.proyectoadsprestamo.dominio;

public class Estudiante {
    Integer cedula;
    String nombre;

    public Estudiante(Integer cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public Estudiante() {
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "cedula=" + cedula +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
